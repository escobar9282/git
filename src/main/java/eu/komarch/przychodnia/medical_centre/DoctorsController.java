package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/doctors")
@RestController
public class DoctorsController
{
    private final DoctorsService doctorsService;

    @PostMapping
    public ResponseEntity<Void> addDoctor(@RequestPart MultipartFile menNames, @RequestPart MultipartFile menLastNames, @RequestPart MultipartFile womenNames, @RequestPart MultipartFile womenLastNames,
                                          @RequestPart MultipartFile personalIdentificationNumbers)
    {
        doctorsService.resolveDoctorsData(menNames, menLastNames, womenNames, womenLastNames, personalIdentificationNumbers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
