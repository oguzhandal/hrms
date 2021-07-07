package project.hrms.core.fakeServices.abstracts;

import project.hrms.entities.concretes.Employer;

public interface EmployerVerificationService {
    boolean employerVerificationByEmployee(Employer employer);

}
