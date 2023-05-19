package eu.komarch.przychodnia.medical_centre;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static eu.komarch.przychodnia.medical_centre.DoctorsSpecialization.getAllSpecializations;

@Component
public class NameDataResolver
{
    public List<NameDataPojo> generatedData(List<String> menNames, List<String> menLastNames,
                                            List<String> womenNames, List<String> womenLastNames,
                                            List<String> personalIdentificationNumbers)
    {
        List<NameDataPojo> nameDataPojos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            nameDataPojos.add(createPojo(random, menNames, menLastNames, personalIdentificationNumbers));
        }

        for (int i = 0; i < 100; i++)
        {
            nameDataPojos.add(createPojo(random, womenNames, womenLastNames,personalIdentificationNumbers));
        }
        return nameDataPojos;
    }

    private NameDataPojo createPojo(Random random, List<String> firstNames, List<String> lastNames, List<String> personalIdentificationNumbers)
    {
        int randomNumber = random.nextInt(firstNames.size());
        String firstName = firstNames.get(randomNumber);
        int secondRandomNumber = random.nextInt(firstNames.size());
        String lastName = lastNames.get(secondRandomNumber);
        List<String> specializations = getAllSpecializations();
        int randomSpecialization = random.nextInt(specializations.size());
        String specialization = specializations.get(randomSpecialization);
        int personalIdentificationNumber = random.nextInt(personalIdentificationNumbers.size());
        Long PIN = Long.parseLong(personalIdentificationNumbers.get(personalIdentificationNumber));
        return new NameDataPojo(firstName, lastName, specialization, PIN);
    }
}
