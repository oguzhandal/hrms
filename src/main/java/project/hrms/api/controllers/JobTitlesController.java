package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobTitle;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles/")
public class JobTitlesController {
    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("getall")
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.add(jobTitle);
    }
}
