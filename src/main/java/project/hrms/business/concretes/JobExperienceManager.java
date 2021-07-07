package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobExperienceDao;
import project.hrms.entities.concretes.JobExperience;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), "İş tecrübesi listelendi");
    }

    @Override
    public DataResult<List<JobExperience>> getAllSortedByCompletionDate() {
        Sort sort = Sort.by(Sort.Direction.ASC, "completionDate");
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(sort), "İş tecrübeleri sıralı olarak listelendi");
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("İş tecrübesi eklendi");
    }
}
