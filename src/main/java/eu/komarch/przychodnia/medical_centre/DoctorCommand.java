package eu.komarch.przychodnia.medical_centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorCommand
{
    @NotNull
    private Long personalIdentificationNumber;
    @NotNull
    private String speciality;
    @NotNull
    private String doctorsName;
    @NotNull
    private String doctorsLastName;
}
