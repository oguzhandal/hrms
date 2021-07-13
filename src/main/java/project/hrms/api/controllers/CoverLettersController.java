package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.CoverLetterForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CoverLetterForCV;

import java.util.List;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

    private CoverLetterForCVService coverLetterForCVService;

    @Autowired
    public CoverLettersController(CoverLetterForCVService coverLetterForCVService) {
        super();
        this.coverLetterForCVService = coverLetterForCVService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CoverLetterForCV coverLetterForCV) {
        return this.coverLetterForCVService.add(coverLetterForCV);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CoverLetterForCV coverLetterForCV) {
        return this.coverLetterForCVService.update(coverLetterForCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.coverLetterForCVService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<CoverLetterForCV> getById(@RequestParam("id") int id) {
        return this.coverLetterForCVService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<CoverLetterForCV>> getAll() {
        return this.coverLetterForCVService.getAll();
    }

}