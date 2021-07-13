package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    Result add(JobAdvert jobAdvert);

    Result update(JobAdvert jobAdvert);

    Result delete(int id);

    Result changeOpenToClose(int id);

    DataResult<JobAdvert> getById(int id);

    DataResult<List<JobAdvert>> getAll();

    DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

    DataResult<List<JobAdvert>> findAllByOrderByPublishedAt();

    DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
}
