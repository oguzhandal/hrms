package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.dtos.JobSeekerCvDto;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobseekersController {

    private JobSeekerService jobseekerService;

    @Autowired
    public JobseekersController(JobSeekerService jobseekerService) {
        super();
        this.jobseekerService = jobseekerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobseeker) {
        return this.jobseekerService.add(jobseeker);
    }
//
//	@PostMapping("/update")
//	public Result update(@RequestBody Jobseeker jobseeker){
//		return this.jobseekerService.update(jobseeker);
//	}
//
//	@PostMapping("/delete")
//	public Result delete(@RequestParam("id") int id){
//		return this.jobseekerService.delete(id);
//	}
//
//	@GetMapping("/getbyid")
//	public DataResult<Jobseeker> getById(@RequestParam("id") int id){
//		return this.jobseekerService.getById(id);
//	}

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobseekerService.getAll();
    }

    @GetMapping("/getJobSeekerCvById")
    public DataResult<JobSeekerCvDto> getJobSeekerCvById(@RequestParam int id) {
        return this.jobseekerService.getJobSeekerCvById(id);
    }

}