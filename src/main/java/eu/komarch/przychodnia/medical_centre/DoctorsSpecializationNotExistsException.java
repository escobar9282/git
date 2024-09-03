package eu.komarch.przychodnia.medical_centre;

public class DoctorsSpecializationNotExistsException extends RuntimeException
{
    private static final String MESSAGE = "Whether this specialization does not exist for %s affliction.Try again later.";

    public DoctorsSpecializationNotExistsException(String affliction)
    {
        super(String.format(MESSAGE, affliction));
    }
}
