package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

@RestController
@RequestMapping("api/jobadvertisements/")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("getAllStatusTrue")
    public DataResult<List<JobAdvertisement>> getAllStatusTrue() {
        return this.jobAdvertisementService.getAllStatusTrue();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("getAllSortedByLastDate")
    public DataResult<List<JobAdvertisement>> getAllSortedByLastDate() {
        return this.jobAdvertisementService.getAllSortedByLastDate();
    }

    @GetMapping("getAllEmployerAndStatusTrue")
    public DataResult<List<JobAdvertisement>> getAllEmployerAndStatusTrue(@RequestParam("companyName") String companyName) {

        return this.jobAdvertisementService.getAllEmployerAndStatusTrue(companyName);

    }

    @PostMapping("setStatus")
    public Result update(int id, boolean status) {
        return this.jobAdvertisementService.update(id, status);
    }


}
