package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.ExperienceForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ExperienceForCV;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

    private ExperienceForCVService experienceForCVService;

    @Autowired
    public ExperiencesController(ExperienceForCVService experienceForCVService) {
        super();
        this.experienceForCVService = experienceForCVService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ExperienceForCV experienceForCV) {
        return this.experienceForCVService.add(experienceForCV);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ExperienceForCV experienceForCV) {
        return this.experienceForCVService.update(experienceForCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.experienceForCVService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<ExperienceForCV> getById(@RequestParam int id) {
        return this.experienceForCVService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ExperienceForCV>> getAll() {
        return this.experienceForCVService.getAll();
    }

    @GetMapping("/getAllByJobSeekerIdOrderByEndAtDesc")
    public DataResult<List<ExperienceForCV>> getAllByJobSeekerIdOrderByEndAtDesc(@RequestParam("id") int id) {
        return this.experienceForCVService.getAllByJobSeekerIdOrderByCompletionDateDesc(id);
    }

    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<ExperienceForCV>> getAllByJobSeekerId(@RequestParam int id) {
        return this.experienceForCVService.getAllByJobSeekerId(id);
    }
}