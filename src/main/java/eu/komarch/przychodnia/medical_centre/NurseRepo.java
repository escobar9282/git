package eu.komarch.przychodnia.medical_centre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepo extends JpaRepository<NurseEntity, Long> {
}
