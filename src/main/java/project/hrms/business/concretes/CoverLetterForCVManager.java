package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CoverLetterForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CoverLetterForCvDao;
import project.hrms.entities.concretes.CoverLetterForCV;

import java.util.List;

@Service
public class CoverLetterForCVManager implements CoverLetterForCVService {

    private CoverLetterForCvDao coverLetterForCvDao;

    @Autowired
    public CoverLetterForCVManager(CoverLetterForCvDao coverLetterForCvDao) {
        super();
        this.coverLetterForCvDao = coverLetterForCvDao;
    }

    @Override
    public Result add(CoverLetterForCV coverLetterForCV) {
        this.coverLetterForCvDao.save(coverLetterForCV);
        return new SuccessResult("Cover letter has been added.");
    }

    @Override
    public Result update(CoverLetterForCV coverLetterForCV) {
        this.coverLetterForCvDao.save(coverLetterForCV);
        return new SuccessResult("Cover letter has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.coverLetterForCvDao.deleteById(id);
        return new SuccessResult("Cover letter has been deleted.");
    }

    @Override
    public DataResult<CoverLetterForCV> getById(int id) {
        return new SuccessDataResult<CoverLetterForCV>(this.coverLetterForCvDao.getById(id));
    }

    @Override
    public DataResult<List<CoverLetterForCV>> getAll() {
        return new SuccessDataResult<List<CoverLetterForCV>>(this.coverLetterForCvDao.findAll());
    }

}
