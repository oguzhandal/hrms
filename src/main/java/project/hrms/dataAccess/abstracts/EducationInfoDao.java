package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.EducationInfo;

public interface EducationInfoDao extends JpaRepository<EducationInfo, Integer> {
}
