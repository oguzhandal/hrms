package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.ImageForCV;

public interface ImageForCVDao extends JpaRepository<ImageForCV, Integer> {

    ImageForCV getById(int id);

    ImageForCV getByJobSeeker_id(int id);
}