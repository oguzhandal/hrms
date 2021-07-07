package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobExperience;

import java.util.List;

@RestController
@RequestMapping("/api/jobexperience/")
public class JobExperiencesController {
    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("getall")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }

    @GetMapping("getAllSortedByCompletionDate")
    public DataResult<List<JobExperience>> getAllSortedByCompletionDate() {
        return this.jobExperienceService.getAllSortedByCompletionDate();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }
}
