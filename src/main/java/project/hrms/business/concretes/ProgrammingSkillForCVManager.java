package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.ProgrammingSkillForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ProgrammingSkillForCVDao;
import project.hrms.entities.concretes.ProgrammingSkillForCV;

import java.util.List;

@Service
public class ProgrammingSkillForCVManager implements ProgrammingSkillForCVService {

    private ProgrammingSkillForCVDao programmingSkillForCVDao;


    @Autowired
    public ProgrammingSkillForCVManager(ProgrammingSkillForCVDao programmingSkillForCVDao) {
        super();
        this.programmingSkillForCVDao = programmingSkillForCVDao;
    }

    @Override
    public Result add(ProgrammingSkillForCV programmingSkillForCV) {
        this.programmingSkillForCVDao.save(programmingSkillForCV);
        return new SuccessResult("Programming skill has been added.");
    }

    @Override
    public Result update(ProgrammingSkillForCV programmingSkillForCV) {
        this.programmingSkillForCVDao.save(programmingSkillForCV);
        return new SuccessResult("Programming skill has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.programmingSkillForCVDao.deleteById(id);
        return new SuccessResult("Programming skill has been deleted.");
    }

    @Override
    public DataResult<ProgrammingSkillForCV> getById(int id) {
        return new SuccessDataResult<ProgrammingSkillForCV>(this.programmingSkillForCVDao.getById(id));
    }

    @Override
    public DataResult<List<ProgrammingSkillForCV>> getAll() {
        return new SuccessDataResult<List<ProgrammingSkillForCV>>(this.programmingSkillForCVDao.findAll());
    }

    @Override
    public DataResult<List<ProgrammingSkillForCV>> getAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<ProgrammingSkillForCV>>(this.programmingSkillForCVDao.getAllByJobSeeker_id(id));
    }

}