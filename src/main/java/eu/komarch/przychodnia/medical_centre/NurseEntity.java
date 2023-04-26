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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String patientHistoryFirstNames;
    private String patientHistoryLastNames;
    private String patientAffliction;
    private String patientAppointmentWithDoctor;

    @JsonIgnore
    @ManyToMany
    private Set<PatientEntity> patient;

    @JsonIgnore
    @ManyToMany
    private Set<DoctorEntity> relationWithDoctor;
}
