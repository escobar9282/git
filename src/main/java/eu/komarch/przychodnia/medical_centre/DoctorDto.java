package eu.komarch.przychodnia.medical_centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto
{
    private Long personalIdentificationNumber;
    private String speciality;
    private String doctorsName;
    private String doctorsLastName;
    private String patientsChecklistTiming;
}
