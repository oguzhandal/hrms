package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import project.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "İş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllStatusTrue(), "Aktif iş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSortedByLastDate() {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdAt");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Tarihe gör sıralı şekilde listelendi ");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllEmployerAndStatusTrue(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllEmployerAndStatusTrue(companyName), "İş verenlere göre iş ilanları listelendi.");
    }

    @Override
    public Result update(int id, boolean status) {
        JobAdvertisement jobAdvertisementupdate = this.jobAdvertisementDao.findById(id).get();
        jobAdvertisementupdate.setStatus(status);
        this.jobAdvertisementDao.save(jobAdvertisementupdate);
        return new SuccessResult("İş ilanının durumu değiştirildi");
    }
}
