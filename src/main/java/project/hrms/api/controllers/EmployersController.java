package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @GetMapping("findByEmail")
    public DataResult<List<Employer>> findByEmail(@RequestBody String email) {
        return this.employerService.findByEmail(email);
    }


    @PostMapping("add")
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }
}
