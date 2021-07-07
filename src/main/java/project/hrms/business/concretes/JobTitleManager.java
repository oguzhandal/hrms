package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobTitleDao;
import project.hrms.entities.concretes.JobTitle;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "İş pozisyonları listelendi.");
    }

    @Override
    public Result add(JobTitle jobTitle) {
        if (!CheckTitle(jobTitle.getTitle())) {
            return new ErrorResult("Title tekrar edemez");
        }
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Pozisyon eklendi");
    }

    private boolean CheckTitle(String title) {
        if (this.jobTitleDao.getByTitle(title) == null) {
            return true;
        }
        return false;
    }
}
