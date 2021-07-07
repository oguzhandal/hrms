package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;
import project.hrms.verification.abstracts.EmailCheckService;
import project.hrms.verification.abstracts.MernisCheckService;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private MernisCheckService mernisCheckService;
    private EmailCheckService emailCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService, EmailCheckService emailCheckService) {
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
        if (candidate.getFirstName() == null || candidate.getLastName() == null ||
                candidate.getEmail() == null || candidate.getPassword() == null ||
                candidate.getIdentityNumber() == null || candidate.getBirthYear() == 0) {
            return new ErrorResult("Lütfen Tüm alanları eksiksiz doldurunuz");
        } else if (!ceckcEmail(candidate.getEmail())) {
            return new ErrorResult("Email kullanılmamaktadır");
        } else if (!checkIdentityNumber(candidate.getIdentityNumber())) {
            return new ErrorResult("Geçersiz Kimlik numarası");
        } else if (!this.mernisCheckService.checkIfRealPerson(candidate)) {
            return new ErrorResult("Mernis doğrulaması başarısız!");
        } else if (!this.emailCheckService.checkIfRealEmail(candidate)) {
            return new ErrorResult("Geçersiz Email!");
        }
        this.candidateDao.save(candidate);
        return new SuccessResult("Kayıt başarılı.");
    }

    private boolean ceckcEmail(String email) {
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
