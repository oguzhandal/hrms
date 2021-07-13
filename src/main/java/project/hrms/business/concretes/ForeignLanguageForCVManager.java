package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.ForeignLanguageForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ForeignLanguageForCvDao;
import project.hrms.entities.concretes.ForeignLanguageForCV;

import java.util.List;

@Service
public class ForeignLanguageForCVManager implements ForeignLanguageForCVService {

    private ForeignLanguageForCvDao foreignLanguageForCvDao;

    @Autowired
    public ForeignLanguageForCVManager(ForeignLanguageForCvDao foreignLanguageForCvDao) {
        super();
        this.foreignLanguageForCvDao = foreignLanguageForCvDao;
    }

    @Override
    public Result add(ForeignLanguageForCV foreignLanguageForCV) {
        this.foreignLanguageForCvDao.save(foreignLanguageForCV);
        return new SuccessResult("Foreign language has been added.");
    }

    @Override
    public Result update(ForeignLanguageForCV foreignLanguageForCV) {
        this.foreignLanguageForCvDao.save(foreignLanguageForCV);
        return new SuccessResult("Foreign language has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.foreignLanguageForCvDao.deleteById(id);
        ;
        return new SuccessResult("Foreign language has been deleted.");
    }

    @Override
    public DataResult<ForeignLanguageForCV> getById(int id) {
        return new SuccessDataResult<ForeignLanguageForCV>(this.foreignLanguageForCvDao.getById(id));
    }

    @Override
    public DataResult<List<ForeignLanguageForCV>> getAll() {
        return new SuccessDataResult<List<ForeignLanguageForCV>>(this.foreignLanguageForCvDao.findAll());
    }

    @Override
    public DataResult<List<ForeignLanguageForCV>> getAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<ForeignLanguageForCV>>(this.foreignLanguageForCvDao.getAllByJobSeeker_id(id));
    }

}