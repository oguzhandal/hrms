package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.core.utulities.results.*;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;
import project.hrms.verification.abstracts.EmailCheckService;
import project.hrms.verification.abstracts.MernisCheckService;

import java.util.List;

public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private MernisCheckService mernisCheckService;
    private EmailCheckService emailCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService,
                            EmailCheckService emailCheckService) {
        super();
        this.candidateDao = candidateDao;
        this.mernisCheckService = mernisCheckService;
        this.emailCheckService = emailCheckService;

    }

    @Override
    public DataResult<List<Candidate>> getAll() {

        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi.");
    }

    @Override
    public Result add(Candidate candidate) {

        if (candidate.getFirstName() == null || candidate.getLastName() == null || candidate.getEmail() == null
                || candidate.getPassword() == null || candidate.getIdentityNumber() == null
                || candidate.getBirthYear() == 0) {

            return new ErrorResult("Tüm alanları doldurunuz!");
        }

        else if (!checkEmail(candidate.getEmail())) {
            return new ErrorResult("Email kullanılmaktadır!");
        }

        else if (!checkIdentityNumber(candidate.getIdentityNumber())) {
            return new ErrorResult("TC kimlik numarası kullanılmaktadır!");
        }

        else if (!this.mernisCheckService.checkIfRealPerson(candidate)) {
            return new ErrorResult("Mernis doğrulamasından geçemedi!");
        }

        else if (!this.emailCheckService.checkIfRealEmail(candidate)) {
            return new ErrorResult("Email gerçek değil!");
        }

        this.candidateDao.save(candidate);
        return new SuccessResult("Kayıt başarılı");

    }

    private boolean checkEmail(String email) {
        if (this.candidateDao.getByEmail(email) == null) {
            return true;
        }
        return false;
    }

    private boolean checkIdentityNumber(String identityNumber) {
        if (this.candidateDao.getByIdentityNumber(identityNumber) == null) {
            return true;
        }
        return false;
    }

}
