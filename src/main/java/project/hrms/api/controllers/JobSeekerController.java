package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobSeeker;

import java.util.List;

@RestController
@RequestMapping(name = "/api/jobseeker/")
public class JobSeekerController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping("getall")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.add(jobSeeker);
    }
}
