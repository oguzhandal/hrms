package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ProgrammingSkillForCV;

import java.util.List;

public interface ProgrammingSkillForCVService {
    Result add(ProgrammingSkillForCV programmingSkillForCV);

    Result update(ProgrammingSkillForCV programmingSkillForCV);

    Result delete(int id);

    DataResult<ProgrammingSkillForCV> getById(int id);

    DataResult<List<ProgrammingSkillForCV>> getAll();

    DataResult<List<ProgrammingSkillForCV>> getAllByJobSeekerId(int id);
}
