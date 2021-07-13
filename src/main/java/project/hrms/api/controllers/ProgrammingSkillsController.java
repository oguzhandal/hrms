package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.ProgrammingSkillForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ProgrammingSkillForCV;

import java.util.List;

@RestController
@RequestMapping("/api/programmingSkills")
public class ProgrammingSkillsController {

    private ProgrammingSkillForCVService programmingSkillForCVService;

    @Autowired
    public ProgrammingSkillsController(ProgrammingSkillForCVService programmingSkillForCVService) {
        super();
        this.programmingSkillForCVService = programmingSkillForCVService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProgrammingSkillForCV programmingSkillForCV) {
        return this.programmingSkillForCVService.add(programmingSkillForCV);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ProgrammingSkillForCV programmingSkillForCV) {
        return this.programmingSkillForCVService.update(programmingSkillForCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.programmingSkillForCVService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<ProgrammingSkillForCV> getById(@RequestParam("id") int id) {
        return this.programmingSkillForCVService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ProgrammingSkillForCV>> getAll() {
        return this.programmingSkillForCVService.getAll();
    }

    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<ProgrammingSkillForCV>> getAllByJobSeekerId(@RequestParam int id) {
        return this.programmingSkillForCVService.getAllByJobSeekerId(id);
    }
}
