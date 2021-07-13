package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SchoolForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.SchoolForCVDao;
import project.hrms.entities.concretes.SchoolForCV;

import java.util.List;

@Service
public class SchoolForCVManager implements SchoolForCVService {

    private SchoolForCVDao schoolForCVDao;

    @Autowired
    public SchoolForCVManager(SchoolForCVDao schoolForCVDao) {
        super();
        this.schoolForCVDao = schoolForCVDao;
    }

    @Override
    public Result add(SchoolForCV schoolForCV) {
        this.schoolForCVDao.save(schoolForCV);
        return new SuccessResult("School has been added.");
    }

    @Override
    public Result update(SchoolForCV schoolForCV) {
        this.schoolForCVDao.save(schoolForCV);
        return new SuccessResult("School has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.schoolForCVDao.deleteById(id);
        return new SuccessResult("School has been deleted.");
    }

    @Override
    public DataResult<SchoolForCV> getById(int id) {
        return new SuccessDataResult<SchoolForCV>(this.schoolForCVDao.getById(id));
    }

    @Override
    public DataResult<List<SchoolForCV>> getAll() {
        return new SuccessDataResult<List<SchoolForCV>>(this.schoolForCVDao.findAll());
    }

    @Override
    public DataResult<List<SchoolForCV>> getAllByJobSeekerIdOrderByEndAtDesc(int id) {
        return new SuccessDataResult<List<SchoolForCV>>(this.schoolForCVDao.getAllByJobSeeker_idOrderByEndAtDesc(id));
    }

    @Override
    public DataResult<List<SchoolForCV>> getAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<SchoolForCV>>(this.schoolForCVDao.getAllByJobSeeker_id(id));
    }

}
