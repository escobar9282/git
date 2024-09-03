package eu.komarch.przychodnia.medical_centre;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PatientDataHistory {
    @Column(name="personal_data")
    private String personalData;
    @Column(name="history_of_current_diseases")
    private String historyOfCurrentDiseases;
    @Column(name="history_of_past_diseases")
    private String historyOfPastDiseases;
    @Column(name="family_history")
    private String familyHistory;
    @Column(name="medication_usage")
    private String medicationUsage;
    @Column(name="medicines")
    private String medicines;
    @Column(name="life_style")
    private String lifeStyle;
    @Column(name="course_of_treatment")
    private String courseOfTreatment;
}
