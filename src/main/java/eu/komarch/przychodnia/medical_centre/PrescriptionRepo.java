package eu.komarch.przychodnia.medical_centre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PrescriptionRepo extends JpaRepository<PrescriptionEntity, Long>
{
}
