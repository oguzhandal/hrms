package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    DataResult<List<Employer>> findByEmail(String email);

    Result add(Employer employer);
}
