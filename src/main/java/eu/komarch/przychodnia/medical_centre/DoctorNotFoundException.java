package eu.komarch.przychodnia.medical_centre;

public class DoctorNotFoundException extends RuntimeException
{
    private final static String MESSAGE = "Doctor with id %s not exists";
    private final static String MESSAGE2 = "Doctor with Specialization %s not exists";
    public DoctorNotFoundException(String message) {
        super(String.format( MESSAGE2 ,message));
    }

    public DoctorNotFoundException(Long id)
    {
        super(String.format(MESSAGE, id));
    }
}
