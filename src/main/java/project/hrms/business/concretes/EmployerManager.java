package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utulities.results.*;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;
import project.hrms.verification.abstracts.EmailCheckService;
import project.hrms.verification.abstracts.HrmsCheckService;

import java.util.List;

public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailCheckService emailCheckService;
    private HrmsCheckService hrmsCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,EmailCheckService emailCheckService,HrmsCheckService hrmsCheckService) {
        super();
        this.employerDao = employerDao;
        this.emailCheckService = emailCheckService;
        this.hrmsCheckService = hrmsCheckService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {

        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
    }

    @Override
    public Result add(Employer employer) {

        if(employer.getCompanyName() == null || employer.getEmail() == null
                || employer.getPassword() == null || employer.getPhoneNumber() == null
                || employer.getWebAddress() == null) {
            return new ErrorResult("Tüm alanları doldurunuz!");
        }

        else if(!checkEmail(employer.getEmail())) {
            return new ErrorResult("Email kullanılmaktadır!");
        }

        else if(!this.emailCheckService.checkIfRealEmail(employer)) {
            return new ErrorResult("Email geçerli değil!");
        }

        else if(!this.hrmsCheckService.checkIfConfirmHrms(employer)) {
            return new ErrorResult("Hrms personeli onaylamadı!");
        }

        this.employerDao.save(employer);
        return new SuccessResult("Kayıt başarılı");


    }

    private boolean checkEmail(String email) {
        if(this.employerDao.getByEmail(email) == null) {
            return true;
        }
        return false;
    }
}
