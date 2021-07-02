package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    Candidate getByEmail(String email);

    Candidate getByIdentityNumber(String identityNumber);

}
