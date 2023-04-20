package eu.komarch.przychodnia.medical_centre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionEntity
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String prescription;
    private String medication;
    private int numberOfMedications;
    private String procedure;

    @ManyToOne
    @JoinColumn(name = "doctor_entity_id")
    private DoctorEntity doctor;
}
