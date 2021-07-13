package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.SchoolForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.SchoolForCV;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private SchoolForCVService schoolForCVService;

    @Autowired
    public SchoolsController(SchoolForCVService schoolForCVService) {
        super();
        this.schoolForCVService = schoolForCVService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolForCV schoolForCV) {
        return this.schoolForCVService.add(schoolForCV);
    }

    @PostMapping("/update")
    public Result update(@RequestBody SchoolForCV schoolForCV) {
        return this.schoolForCVService.update(schoolForCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.schoolForCVService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<SchoolForCV> getById(@RequestParam int id) {
        return this.schoolForCVService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolForCV>> getAll() {
        return this.schoolForCVService.getAll();
    }

    @GetMapping("/getAllByJobSeekerIdOrderByEndAtDesc")
    public DataResult<List<SchoolForCV>> getAllByJobSeekerIdOrderByEndAtDesc(@RequestParam int id) {
        return this.schoolForCVService.getAllByJobSeekerIdOrderByEndAtDesc(id);
    }

    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<SchoolForCV>> getAllByJobSeekerId(@RequestParam int id) {
        return this.schoolForCVService.getAllByJobSeekerId(id);
    }
}