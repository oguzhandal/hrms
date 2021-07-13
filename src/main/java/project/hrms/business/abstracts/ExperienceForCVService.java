package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ExperienceForCV;

import java.util.List;

public interface ExperienceForCVService {
    Result add(ExperienceForCV experienceForCV);

    Result update(ExperienceForCV experienceForCV);

    Result delete(int id);

    DataResult<ExperienceForCV> getById(int id);

    DataResult<List<ExperienceForCV>> getAll();

    DataResult<List<ExperienceForCV>> getAllByJobSeekerIdOrderByCompletionDateDesc(int id);

    DataResult<List<ExperienceForCV>> getAllByJobSeekerId(int id);
}
