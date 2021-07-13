package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CoverLetterForCV;

import java.util.List;

public interface CoverLetterForCVService {
    Result add(CoverLetterForCV coverLetterForCV);

    Result update(CoverLetterForCV coverLetterForCV);

    Result delete(int id);

    DataResult<CoverLetterForCV> getById(int id);

    DataResult<List<CoverLetterForCV>> getAll();
}
