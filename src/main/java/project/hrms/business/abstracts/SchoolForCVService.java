package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.SchoolForCV;

import java.util.List;

public interface SchoolForCVService {
    Result add(SchoolForCV schoolForCV);

    Result update(SchoolForCV schoolForCV);

    Result delete(int id);

    DataResult<SchoolForCV> getById(int id);

    DataResult<List<SchoolForCV>> getAll();

    DataResult<List<SchoolForCV>> getAllByJobSeekerIdOrderByEndAtDesc(int id);

    DataResult<List<SchoolForCV>> getAllByJobSeekerId(int id);
}