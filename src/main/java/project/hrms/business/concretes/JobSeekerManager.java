package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobSeekerDao;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.verification.abstracts.EmailCheckService;
import project.hrms.verification.abstracts.MernisCheckService;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private MernisCheckService mernisCheckService;
    private EmailCheckService emailCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService, EmailCheckService emailCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService = mernisCheckService;
        this.emailCheckService = emailCheckService;
    }


    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (jobSeeker.getFirstName() == null || jobSeeker.getLastName() == null ||
                jobSeeker.getEmail() == null || jobSeeker.getPassword() == null ||
                jobSeeker.getIdentityNumber() == null || jobSeeker.getBirthYear() == null) {
            return new ErrorResult("Lütfen Tüm alanları eksiksiz doldurunuz");
        } else if (!ceckcEmail(jobSeeker.getEmail())) {
            return new ErrorResult("Email kullanılmamaktadır");
        } else if (!checkIdentityNumber(jobSeeker.getIdentityNumber())) {
            return new ErrorResult("Geçersiz Kimlik numarası");
        } else if (!this.mernisCheckService.checkIfRealPerson(jobSeeker)) {
            return new ErrorResult("Mernis doğrulaması başarısız!");
        } else if (!this.emailCheckService.checkIfRealEmail(jobSeeker)) {
            return new ErrorResult("Geçersiz Email!");
        }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Kayıt başarılı.");
    }

    private boolean ceckcEmail(String email) {
        return this.jobSeekerDao.getByEmail(email) == null;
    }

    private boolean checkIdentityNumber(String identityNumber) {
        return this.jobSeekerDao.getByIdentityNumber(identityNumber) == null;
    }
}
