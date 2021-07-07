package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EducationInfoService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EducationInfoDao;
import project.hrms.entities.concretes.EducationInfo;

import java.util.List;

@Service
public class EducationInfoManager implements EducationInfoService {

    private EducationInfoDao educationInfoDao;

    @Autowired
    public EducationInfoManager(EducationInfoDao educationInfoDao) {
        this.educationInfoDao = educationInfoDao;
    }

    @Override
    public DataResult<List<EducationInfo>> getAll() {
        return new SuccessDataResult<List<EducationInfo>>(this.educationInfoDao.findAll(), "Eğitimler listelendi.");
    }

    @Override
    public DataResult<List<EducationInfo>> getAllSortedCompletionDate() {

        Sort sort = Sort.by(Sort.Direction.ASC, "completionDate");
        return new SuccessDataResult<List<EducationInfo>>(this.educationInfoDao.findAll(sort), "Bitiş yılına göre listelendi.");
    }

    @Override
    public Result add(EducationInfo educationInfo) {
        this.educationInfoDao.save(educationInfo);
        return new SuccessResult("Eğitim eklendi");
    }
}
