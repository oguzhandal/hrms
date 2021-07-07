package project.hrms.core.fakeServices.concretes;

import project.hrms.core.fakeServices.abstracts.EmployerVerificationService;
import project.hrms.entities.concretes.Employer;

public class EmployerVerificationManager implements EmployerVerificationService {
    @Override
    public boolean employerVerificationByEmployee(Employer employer) {
        return true;
    }
}
