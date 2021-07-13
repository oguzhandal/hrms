package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.ForeignLanguageForCV;

import java.util.List;

public interface ForeignLanguageForCvDao extends JpaRepository<ForeignLanguageForCV, Integer> {
    ForeignLanguageForCV getById(int id);

    List<ForeignLanguageForCV> getAllByJobSeeker_id(int id);
}