package eu.komarch.przychodnia.medical_centre;

public class DoctorNotFoundException extends RuntimeException
{
    private final static String MESSAGE = "Doctor with id %s not exists";
    public DoctorNotFoundException(Long id)
    {
        super(String.format(MESSAGE, id));
    }
}
