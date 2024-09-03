package eu.komarch.przychodnia.medical_centre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Table(name = "patient")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity
{
    @Id
    @SequenceGenerator(initialValue=1, name="hibernate_seq", sequenceName="hibernate_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hibernate_seq")
    private Long id;

    private int phoneNumber;
    private String personalIdentificationNumber;
    private String city;
    private String address;
    private String postalCode;
    private int age;
    private String appointmentTimeWithDoctor;
    private String patientNames;
    private String affliction;

    @JsonIgnore
    @ManyToMany(mappedBy = "patient")
    private Set<DoctorEntity> doctor;

    @JsonIgnore
    @ManyToMany(mappedBy = "patient")
    private Set<NurseEntity> nurse;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<PrescriptionEntity> prescriptions;
}
