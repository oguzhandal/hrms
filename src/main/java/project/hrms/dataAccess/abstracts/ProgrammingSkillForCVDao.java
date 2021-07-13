package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.ProgrammingSkillForCV;

import java.util.List;

public interface ProgrammingSkillForCVDao extends JpaRepository<ProgrammingSkillForCV, Integer> {
    ProgrammingSkillForCV getById(int id);

    List<ProgrammingSkillForCV> getAllByJobSeeker_id(int id);
}
