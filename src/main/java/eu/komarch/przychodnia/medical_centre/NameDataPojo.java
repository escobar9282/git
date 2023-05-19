package eu.komarch.przychodnia.medical_centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NameDataPojo {
    private String firstName;
    private String lastName;
    private String specialization;
    private Long personalIdentificationNumber;
}
