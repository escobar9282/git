package eu.komarch.przychodnia.medical_centre;

public class DoctorsSpecializationNotExistsException extends RuntimeException
{
    private static final String MESSAGE = "Whether this specialization does not exist.Try again later.";

    public DoctorsSpecializationNotExistsException()
    {
        super(MESSAGE);
    }
}
