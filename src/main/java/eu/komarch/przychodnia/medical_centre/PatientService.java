package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class PatientService
{
    private final PatientRepo patientRepo;
    private final DoctorsRepo doctorsRepo;
    private final Random random = new Random();
    private final Map<DoctorsSpecialization, List<String>> map = Map.ofEntries(Map.entry
                    (DoctorsSpecialization.DENTYSTA,
                            List.of("Ból zęba", "Afty")), Map.entry(DoctorsSpecialization.ALERGOLOG, List.of("Wysypka", "Łuszczyca", "Alergia")),
            Map.entry(DoctorsSpecialization.DIABETOLOG, List.of("Kontrola cukru", "Nadwaga", "Cukrzyca"
            )), Map.entry(DoctorsSpecialization.GASTROLOG, List.of("Ból brzucha", "Choroba refluksowa")),
            Map.entry(DoctorsSpecialization.GINEKOLOG, List.of("Zakażenie dróg moczowych", "Zespół napięcia przedmiesiączkowego")), Map.entry(DoctorsSpecialization.INTERNISTA,
                    List.of("Zapalenie pęcherzyka żółciowego")), Map.entry(DoctorsSpecialization.ORTOPEDA,
                    List.of("Ból pleców", "Ból stawów", "Złamanie nadgarstka")), Map.entry(DoctorsSpecialization.LARYNGOLOG, List.of("Zapalenie ucha",
                    "Ból gardła", "Zapalenie zatok", "Astma")), Map.entry(DoctorsSpecialization.LEKARZ_RODZINNY, List.of
                    ("Przeziębienie", "Nadciśnienie", "Zmęczenie", "Ból głowy", "Kaszel", "Biegunka", "Oparzenie skóry",
                            "Zapalenie gardła", "Zawroty głowy", "Ból brzucha")),
            Map.entry(DoctorsSpecialization.HEMATOLOG, List.of("Niedokriwistość", "Anemia")),
            Map.entry(DoctorsSpecialization.OKULISTA, List.of("Zapalenie oczu")),
            Map.entry(DoctorsSpecialization.PSYCHIATRA, List.of("Depresja",
                    "Bezsenność")));

    @Transactional
    public void setRepoPatients(InputStream fileInputStream, InputStream inputStream, InputStream adresy, InputStream cities) throws IOException
    {
        byte[] readBytesFromFile = fileInputStream.readAllBytes();
        String convert = new String(readBytesFromFile, StandardCharsets.UTF_8);
        byte[] readBytesFromFile3 = cities.readAllBytes();
        String converttt = new String(readBytesFromFile3, StandardCharsets.UTF_8);
        List<String> pins = readPinForPatient(inputStream);
        List<String> somehow = Arrays.stream(convert.split("\r\n")).skip(3).toList();
        byte[] readBytesFromFile2 = adresy.readAllBytes();
        String convert2 = new String(readBytesFromFile2, StandardCharsets.UTF_8);
        log.info("Convert variable: {}", convert);
        for (String element : somehow)
        {
            String city = createCity(converttt);
            String adress = createAdress(adresy, convert2);
            String checklistTiming = StringUtils.substringBetween(element, "|", "|");
            String patientData = StringUtils.substringBetween(element, "|" + checklistTiming + "|", "|");
            String affliction = StringUtils.substringBetween(element, "|" + patientData + "|", "|");
            log.info("affliction: {}", affliction);
            if (StringUtils.isBlank(affliction.replaceAll("\\s", "")))
            {
                break;
            }
            PatientPojo pojo = new PatientPojo(patientData.trim(), checklistTiming.trim(), affliction.trim(), generatePin(pins), generatorOfPhoneNumbers(), generatorOfPostalCode(), random.nextInt(110), adress, city);
            String result = getDoctorsSpecialization(affliction);
            log.info("Doctor specialization: {}", result);
            assignmentDoctorToPatients(result, checklistTiming);
            patientRepo.save(toEntity(pojo));
        }
    }

    private String createCity(String converttt) {
        List<String> cities = Arrays.asList(converttt.split("\r\n"));
        return StringUtils.substringBefore(cities.get(random.nextInt(cities.size())),"(").trim();
    }

    private String createAdress(InputStream adresy, String convert) throws IOException {
        List<String> addressInPolish = List.of("a", "b", "c", "d", "e", "");
        List<String> streets = Arrays.asList(convert.split("\r\n"));
        return streets.get(random.nextInt(streets.size())) + StringUtils.SPACE + random.nextInt(50) + addressInPolish.get(random.nextInt(addressInPolish.size()));

    }

    private PatientEntity toEntity(PatientPojo pojo)
    {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setAge(pojo.getAge());
        patientEntity.setPatientNames(pojo.getPatientData());
        patientEntity.setCity(pojo.getCity());
        patientEntity.setAppointmentTimeWithDoctor(pojo.getChecklistTiming());
        patientEntity.setAddress(pojo.getAddress());
        patientEntity.setAffliction(pojo.getAffliction());
        patientEntity.setPhoneNumber(pojo.getPhoneNumber());
        patientEntity.setPersonalIdentificationNumber(pojo.getPersonalIdentificationNumber());
        patientEntity.setPostalCode(pojo.getPostalCode());
        return patientEntity;
    }
    private String getDoctorsSpecialization(String affliction)
    {
        List<List<String>> listraStringow = map.values().stream().toList();
        for (List<String> list : listraStringow)
        {
            if (list.contains(affliction.trim()))
            {
                for (Map.Entry <DoctorsSpecialization,List<String>> entry : map.entrySet()) {
                    if (entry.getValue().contains(affliction.trim()))
                    {
                        return entry.getKey().name();
                    }
                }
            }
            else
            {
                continue;
            }
        }
        throw new DoctorsSpecializationNotExistsException(affliction);
    }

    private String generatePin(List<String> personalIdentificationNumbers)
    {
        int personalIdentificationNumber = random.nextInt(personalIdentificationNumbers.size());
        return personalIdentificationNumbers.get(personalIdentificationNumber);
    }

    private List<String> readPinForPatient(InputStream inputStream)
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> object = bufferedReader.lines().toList();
        return object;
    }

    private int generatorOfPhoneNumbers()
    {
       final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++)
        {
            int result = random.nextInt(10);
            if(i == 0 && result == 0){
                while (true) {
                    result = random.nextInt(10);
                    if (result !=0) {
                        break;
                    }
                }
            }
            stringBuilder.append(result);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
    private String generatorOfPostalCode()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++)
        {
            if (i==2)
            {
                stringBuilder.append("-");
                continue;
            }
            int result = random.nextInt(10);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }
    private void assignmentDoctorToPatients(String doctorsSpecialization, String checklistTiming)
    {
        List<DoctorEntity> doctorEntityList = doctorsRepo.findAllBySpeciality(doctorsSpecialization);
        if (doctorEntityList.isEmpty())
            throw new DoctorNotFoundException(doctorsSpecialization);
        int wynik = (int)(Math.random()*doctorEntityList.size());
        DoctorEntity doctorEntity = doctorEntityList.get(wynik);
        if (Objects.isNull(doctorEntity.getPatientsChecklistTiming()))
        {
            doctorEntity.setPatientsChecklistTiming(checklistTiming.trim());
        }
        else
        {
            String currentChecklistTiming = doctorEntity.getPatientsChecklistTiming();
            doctorEntity.setPatientsChecklistTiming(currentChecklistTiming + StringUtils.SPACE + checklistTiming.trim());
        }
    }

}