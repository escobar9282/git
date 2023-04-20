package eu.komarch.przychodnia.medical_centre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DoctorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int personalIdentificationNumber;
    private String speciality;
    private String doctorsName;
    private String doctorsLastName;

    @OneToMany(mappedBy = "doctor_entity")
    private Set<PrescriptionEntity> prescriptionEntities;

    @ManyToMany
    private Set<PatientEntity> relationFromDoctor;

}
