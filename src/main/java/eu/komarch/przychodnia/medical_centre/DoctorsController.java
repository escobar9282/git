package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
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
    public ResponseEntity<Void> addDoctor(@RequestPart Resource menNames, @RequestPart MultipartFile menLastNames, @RequestPart Resource womenNames, @RequestPart Resource womenLastNames) throws IOException {
        doctorsService.resolveDoctorsData(menNames.getFile(), menLastNames.getResource().getFile(), womenNames.getFile(), womenLastNames.getFile());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
