package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.LinkForCV;

import java.util.List;

public interface LinkForCVDao extends JpaRepository<LinkForCV, Integer> {
    LinkForCV getById(int id);

    List<LinkForCV> getAllByJobSeeker_id(int id);
}