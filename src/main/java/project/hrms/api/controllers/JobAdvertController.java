package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobAdvertService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvert;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvert")
public class JobAdvertController {

    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertController(JobAdvertService jobAdvertService) {
        super();
        this.jobAdvertService = jobAdvertService;
    }


    @PostMapping("/add")

    public Result add(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.add(jobAdvert);
    }

    //
//	@PostMapping("/update")
//	public Result update(@RequestBody JobAdvert jobAdvert){
//		return this.jobAdvertService.update(jobAdvert);
//	}
//
//	@PostMapping("/delete")
//	public Result delete(@RequestParam("id") int id){
//		return this.jobAdvertService.delete(id);
//	}
//
    @GetMapping("/getbyid")
    public DataResult<JobAdvert> getById(@RequestParam int id) {
        return this.jobAdvertService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvert>> getAll() {
        return this.jobAdvertService.getAll();
    }

    @PostMapping("/changeOpenToClose")
    public Result changeOpenToClose(@RequestParam int id) {
        return this.jobAdvertService.changeOpenToClose(id);
    }

    @GetMapping("/getAllOpenJobAdvertList")
    public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
        return this.jobAdvertService.getAllOpenJobAdvertList();
    }

    @GetMapping("/findAllByOrderByPublishedAt")
    public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt() {
        return this.jobAdvertService.findAllByOrderByPublishedAt();
    }

    @GetMapping("/getAllOpenJobAdvertByEmployer")
    public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(@RequestParam int id) {
        return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
    }
}
