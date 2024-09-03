package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NurseService {
    private final NurseRepo nurseRepo;
}
