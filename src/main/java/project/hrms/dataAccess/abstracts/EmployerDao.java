package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    List<Employer> findByEmail(String email);
}
