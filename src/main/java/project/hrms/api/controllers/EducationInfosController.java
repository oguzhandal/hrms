package project.hrms.api.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.EducationInfoService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.EducationInfo;

import java.util.List;

@RestController
@RequestMapping("/api/educationInfo")
public class EducationInfosController {
    private EducationInfoService educationInfoService;

    @Autowired
    public EducationInfosController(EducationInfoService educationInfoService) {
        this.educationInfoService = educationInfoService;
    }

    @GetMapping("/getall")
    public DataResult<List<EducationInfo>> getAll() {
        return this.educationInfoService.getAll();
    }

    @GetMapping("/getAllSortedByCompletionDate")
    public DataResult<List<EducationInfo>> getAllSortedByCompletionDate() {
        return this.educationInfoService.getAllSortedCompletionDate();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EducationInfo educationInfo) {
        return this.educationInfoService.add(educationInfo);
    }
}
