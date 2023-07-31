package eu.komarch.przychodnia.medical_centre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsRepo extends JpaRepository<DoctorEntity, Long>
{
    List<DoctorEntity> findAllBySpeciality(String speciality);
}
