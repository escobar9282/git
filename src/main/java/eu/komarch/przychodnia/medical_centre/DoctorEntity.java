package eu.komarch.przychodnia.medical_centre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@Table(name = "doctor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DoctorEntity
{
    @Id
    @SequenceGenerator(initialValue=1, name="hibernate_seq", sequenceName="hibernate_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hibernate_seq")
    private Long id;

    private Long personalIdentificationNumber;
    private String speciality;
    private String doctorsName;
    private String doctorsLastName;
    private String patientsChecklistTiming;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private Set<PrescriptionEntity> prescription;

    @JsonIgnore
    @ManyToMany
    private Set<PatientEntity> patient;

    @JsonIgnore
    @ManyToMany
    private Set<NurseEntity> nurse;

}
