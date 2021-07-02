package project.hrms.business.abstracts;

import project.hrms.core.utulities.results.DataResult;
import project.hrms.core.utulities.results.Result;
import project.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    Result add(Employer employer);
}
