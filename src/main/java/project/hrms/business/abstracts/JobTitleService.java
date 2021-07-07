package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();

    Result add(JobTitle jobTitle);
}
