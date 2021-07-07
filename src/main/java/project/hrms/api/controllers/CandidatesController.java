package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping(name = "/api/candidates/")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("getall")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.add(candidate);
    }
}
