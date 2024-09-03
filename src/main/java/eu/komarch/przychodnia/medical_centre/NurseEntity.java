package eu.komarch.przychodnia.medical_centre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "nurse")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NurseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;

    @Embedded
    private PatientDataHistory patientsDataHistory;
    private String patientAffliction;
    private String patientAppointmentWithDoctor;

    @JsonIgnore
    @ManyToMany
    private Set<PatientEntity> patient;

    @JsonIgnore
    @ManyToMany(mappedBy = "nurse")
    private Set<DoctorEntity> doctor;
}
