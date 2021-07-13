package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.dtos.JobSeekerCvDto;

import java.util.List;

public interface JobSeekerService {
    Result add(JobSeeker jobseeker);

    Result update(JobSeeker jobseeker);

    Result delete(int id);

    DataResult<JobSeeker> getById(int id);

    DataResult<List<JobSeeker>> getAll();

    DataResult<JobSeeker> findJobSeekerByIdentityNumber(String IdentityId);

    DataResult<JobSeekerCvDto> getJobSeekerCvById(int id);
}
