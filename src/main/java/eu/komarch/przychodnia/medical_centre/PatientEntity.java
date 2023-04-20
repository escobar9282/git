package eu.komarch.przychodnia.medical_centre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int phoneNumber;
    private int personalIdentificationNumber;
    private String city;
    private String address;
    private String postalCode;
    private String ill;
    private String healthy;
    private int age;

    @ManyToMany
    private Set<DoctorEntity> doctor;
}
