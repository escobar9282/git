package eu.komarch.przychodnia.medical_centre;

import java.util.List;
import java.util.stream.Stream;

public enum DoctorsSpecialization
{
    PEDIATRA, LEKARZ_RODZINNY, INTERNISTA, DENTYSTA, GINEKOLOG, PULMUNOLOG, LARYNGOLOG, ALERGOLOG,
    DIABETOLOG, ORTOPEDA, KARDIOLOG, OKULISTA, PROKTOLOG, HEMATOLOG, PSYCHIATRA, GASTROLOG;

    public static List<String> getAllSpecializations()
    {
        return Stream.of(DoctorsSpecialization.values()).map(DoctorsSpecialization::name).toList();
    }
}
