package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.ExperienceForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ExperienceForCVDao;
import project.hrms.entities.concretes.ExperienceForCV;

import java.util.List;

@Service
public class ExperienceForCVManager implements ExperienceForCVService {

    private ExperienceForCVDao experienceForCVDao;

    @Autowired
    public ExperienceForCVManager(ExperienceForCVDao experienceForCVDao) {
        super();
        this.experienceForCVDao = experienceForCVDao;
    }

    @Override
    public Result add(ExperienceForCV experienceForCV) {
        this.experienceForCVDao.save(experienceForCV);
        return new SuccessResult("Experience has been added.");
    }

    @Override
    public Result update(ExperienceForCV experienceForCV) {
        this.experienceForCVDao.save(experienceForCV);
        return new SuccessResult("Experience has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.experienceForCVDao.deleteById(id);
        return new SuccessResult("Experience has been deleted.");
    }

    @Override
    public DataResult<ExperienceForCV> getById(int id) {
        return new SuccessDataResult<ExperienceForCV>(this.experienceForCVDao.getById(id));
    }

    @Override
    public DataResult<List<ExperienceForCV>> getAll() {
        return new SuccessDataResult<List<ExperienceForCV>>(this.experienceForCVDao.findAll());
    }

    @Override
    public DataResult<List<ExperienceForCV>> getAllByJobSeekerIdOrderByCompletionDateDesc(int id) {
        return new SuccessDataResult<List<ExperienceForCV>>(this.experienceForCVDao.getAllByJobSeekerIdOrderByCompletionDateDesc(id));
    }

    @Override
    public DataResult<List<ExperienceForCV>> getAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<ExperienceForCV>>(this.experienceForCVDao.getAllByJobSeeker_id(id));
    }
}