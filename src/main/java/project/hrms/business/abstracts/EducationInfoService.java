package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.EducationInfo;

import java.util.List;

public interface EducationInfoService {
    DataResult<List<EducationInfo>> getAll();

    DataResult<List<EducationInfo>> getAllSortedCompletionDate();

    Result add(EducationInfo educationInfo);
}
