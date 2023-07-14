package eu.komarch.przychodnia.medical_centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PatientPojo
{
    private String patientData;
    private String checklistTiming;
    private String affliction;
    private Long personalIdentificationNumber;
}
