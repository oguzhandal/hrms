package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.LinkForCV;

import java.util.List;

public interface LinkForCVService {
    Result add(LinkForCV linkForCV);

    Result update(LinkForCV linkForCV);

    Result delete(int id);

    DataResult<LinkForCV> getById(int id);

    DataResult<List<LinkForCV>> getAll();

    DataResult<List<LinkForCV>> getAllByJobSeekerId(int id);
}
