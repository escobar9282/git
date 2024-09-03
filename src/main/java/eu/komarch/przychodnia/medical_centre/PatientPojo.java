package eu.komarch.przychodnia.medical_centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class PatientPojo
{
    private String patientData;
    private String checklistTiming;
    private String affliction;
    private String personalIdentificationNumber;
    private int phoneNumber;
    private String postalCode;
    private int age;
    private String address;
    private String city;
}
