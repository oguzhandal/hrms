package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.JobSeeker;

public interface AuthService {
    Result registerEmployer(Employer employer, String confirmPassword);

    Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword);

}
