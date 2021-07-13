package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ForeignLanguageForCV;

import java.util.List;


public interface ForeignLanguageForCVService {

    Result add(ForeignLanguageForCV foreignLanguageForCV);

    Result update(ForeignLanguageForCV foreignLanguageForCV);

    Result delete(int id);

    DataResult<ForeignLanguageForCV> getById(int id);

    DataResult<List<ForeignLanguageForCV>> getAll();

    DataResult<List<ForeignLanguageForCV>> getAllByJobSeekerId(int id);

}
