package eu.komarch.przychodnia.medical_centre;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int phoneNumber;
    private int personalIdentificationNumber;
    private String city;
    private String address;
    private String postalCode;
    private int age;
    private String appointmentTimeWithDoctor;
    private String patientNames;
    private String affliction;

    @ManyToMany
    private Set<DoctorEntity> doctor;

    @ManyToMany(mappedBy = "patient")
    private Set<NurseEntity> relationWithPatient;
}
