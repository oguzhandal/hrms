package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.SchoolForCV;

import java.util.List;

public interface SchoolForCVDao extends JpaRepository<SchoolForCV, Integer> {
    SchoolForCV getById(int id);

    List<SchoolForCV> getAllByJobSeeker_idOrderByEndAtDesc(int id);

    List<SchoolForCV> getAllByJobSeeker_id(int id);
}