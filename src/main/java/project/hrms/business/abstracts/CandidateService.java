package project.hrms.business.abstracts;

import project.hrms.core.utulities.results.DataResult;
import project.hrms.core.utulities.results.Result;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);

}


