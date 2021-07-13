package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    Result add(JobPosition jobPosition);

    DataResult<List<JobPosition>> getAll();

    DataResult<JobPosition> getJobByTitle(String title);

    //	Result update(JobPosition jobPosition);
//	Result delete(int id);
//	DataResult<JobPosition> getById(int id);
}
