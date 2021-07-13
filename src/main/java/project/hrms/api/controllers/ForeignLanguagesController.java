package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.ForeignLanguageForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ForeignLanguageForCV;

import java.util.List;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {

    private ForeignLanguageForCVService foreignLanguageForCVService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageForCVService foreignLanguageForCVService) {
        super();
        this.foreignLanguageForCVService = foreignLanguageForCVService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ForeignLanguageForCV foreignLanguageForCV) {
        return this.foreignLanguageForCVService.add(foreignLanguageForCV);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ForeignLanguageForCV foreignLanguageForCV) {
        return this.foreignLanguageForCVService.update(foreignLanguageForCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.foreignLanguageForCVService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<ForeignLanguageForCV> getById(@RequestParam("id") int id) {
        return this.foreignLanguageForCVService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ForeignLanguageForCV>> getAll() {
        return this.foreignLanguageForCVService.getAll();
    }

    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<ForeignLanguageForCV>> getAllByJobSeekerId(@RequestParam int id) {
        return this.foreignLanguageForCVService.getAllByJobSeekerId(id);
    }
}