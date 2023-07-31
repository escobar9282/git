package eu.komarch.przychodnia.medical_centre;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Order(HIGHEST_PRECEDENCE)
public class ControllerAdvisor
{
    private static final String SOURCE = "MEDICAL CENTRE API";
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerOfDoctorNotFoundException(DoctorNotFoundException e)
    {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), LocalDateTime.now(), SOURCE);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DoctorsSpecializationNotExistsException.class)
    public ResponseEntity<ErrorMessage> handlerOfDoctorNotFoundException(DoctorsSpecializationNotExistsException e)
    {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), LocalDateTime.now(), SOURCE);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
