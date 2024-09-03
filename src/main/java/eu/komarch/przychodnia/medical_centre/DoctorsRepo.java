package eu.komarch.przychodnia.medical_centre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DoctorsRepo extends JpaRepository<DoctorEntity, Long>
{
    @Query("select d from DoctorEntity d where d.speciality = ?1")
    List<DoctorEntity> findAllBySpeciality(String speciality);
}
