package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    @Query("from JobAdvertisement where status=true ")
    List<JobAdvertisement> getAllStatusTrue();

    @Query("FROM JobAdvertisement  where employer.companyName=:companyName and status=true ")
    List<JobAdvertisement> getAllEmployerAndStatusTrue(String companyName);
}
