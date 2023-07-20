package eu.komarch.przychodnia.medical_centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage
{
    private String description;
    private LocalDateTime localDate;
    private String source;
}
