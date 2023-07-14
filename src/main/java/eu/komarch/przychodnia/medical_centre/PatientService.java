package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientService
{
    private final PatientRepo repoPatients;

    public void setRepoPatients(InputStream fileInputStream,InputStream inputStream) throws IOException {
        byte [] readBytesFromFile = fileInputStream.readAllBytes();
        String convert = new String(readBytesFromFile, StandardCharsets.UTF_8);
        List<String> pins = readPinForPatient(inputStream);
        List<String> somehow = Arrays.stream(convert.split("\r\n")).skip(3).toList();
        for (String element : somehow)
        {
            String checklistTiming = StringUtils.substringBetween(element, "|", "|");
            String patientData = StringUtils.substringBetween(element, "|" + checklistTiming + "|","|");
            String affliction = StringUtils.substringBetween(element, "|" + patientData + "|" , "|");
            PatientPojo pojo = new PatientPojo(patientData.trim(), checklistTiming.trim(), affliction.trim(), generatePin(pins));
        }
    }

    private Long generatePin(List<String> personalIdentificationNumbers)
    {
        Random random = new Random();
        int personalIdentificationNumber = random.nextInt(personalIdentificationNumbers.size());
        return Long.parseLong(personalIdentificationNumbers.get(personalIdentificationNumber));
    }

    private List<String> readPinForPatient(InputStream inputStream)
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> object =  bufferedReader.lines().toList();
        return object;
    }
}
