package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> changeContentOfDoctor(@PathVariable Long id, @RequestBody @Valid DoctorCommand command)
    {
        DoctorDto result = doctorsService.editDoctor(id,command);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
