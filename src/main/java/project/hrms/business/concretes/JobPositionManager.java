package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobPositionService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobPositionDao;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if (getJobByTitle(jobPosition.getJobTitle()).getData() != null) {
            return new ErrorResult(jobPosition.getJobTitle() + " already exists");
        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position has been added.");
    }
//
//	@Override
//	public Result update(JobPosition jobPosition) {
//		this.jobPositionDao.save(jobPosition);
//      return new SuccessResult("Job position has been updated.");
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.jobPositionDao.deleteById(id);
//      return new SuccessResult("Job position has been deleted.");
//	}
//
//	@Override
//	public DataResult<JobPosition> getById(int id) {
//		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id));
//	}

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
    }

    @Override
    public DataResult<JobPosition> getJobByTitle(String title) {

        return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobTitle(title));
    }

}