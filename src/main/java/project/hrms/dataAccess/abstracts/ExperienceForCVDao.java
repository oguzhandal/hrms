package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.ExperienceForCV;

import java.util.List;

public interface ExperienceForCVDao extends JpaRepository<ExperienceForCV, Integer> {
    ExperienceForCV getById(int id);

    List<ExperienceForCV> getAllByJobSeekerIdOrderByCompletionDateDesc(int id);

    List<ExperienceForCV> getAllByJobSeeker_id(int id);
}
