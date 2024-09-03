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
@RequestMapping("/patients")
@RestController
public class PatientController
{
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<Void> addPatients(@RequestPart MultipartFile patientData, @RequestPart MultipartFile pinFile, @RequestPart MultipartFile adresy, @RequestPart MultipartFile cities) throws IOException {
        patientService.setRepoPatients(patientData.getInputStream(), pinFile.getInputStream(), adresy.getInputStream(), cities.getInputStream());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
