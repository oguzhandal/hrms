package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.LinkForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.LinkForCVDao;
import project.hrms.entities.concretes.LinkForCV;

import java.util.List;

@Service
public class LinkForCVManager implements LinkForCVService {

    private LinkForCVDao linkForCVDao;

    @Autowired
    public LinkForCVManager(LinkForCVDao linkForCVDao) {
        super();
        this.linkForCVDao = linkForCVDao;
    }

    @Override
    public Result add(LinkForCV linkForCV) {
        this.linkForCVDao.save(linkForCV);
        return new SuccessResult("Link has been added.");
    }

    @Override
    public Result update(LinkForCV linkForCV) {
        this.linkForCVDao.save(linkForCV);
        return new SuccessResult("Link has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.linkForCVDao.deleteById(id);
        return new SuccessResult("Link has been deleted.");
    }

    @Override
    public DataResult<LinkForCV> getById(int id) {
        return new SuccessDataResult<LinkForCV>(this.linkForCVDao.getById(id));
    }

    @Override
    public DataResult<List<LinkForCV>> getAll() {
        return new SuccessDataResult<List<LinkForCV>>(this.linkForCVDao.findAll());
    }

    @Override
    public DataResult<List<LinkForCV>> getAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<LinkForCV>>(this.linkForCVDao.getAllByJobSeeker_id(id));
    }

}