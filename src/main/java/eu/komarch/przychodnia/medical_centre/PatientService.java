package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@RequiredArgsConstructor
@Service
public class PatientService
{
    private final PatientRepo repoPatients;

    public void setRepoPatients(InputStream fileInputStream,InputStream inputStream)
    {

    }
}
