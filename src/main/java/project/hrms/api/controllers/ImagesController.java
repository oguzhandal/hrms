package project.hrms.api.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.business.abstracts.ImageForCVService;
import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ImageForCV;
import project.hrms.entities.concretes.JobSeeker;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private ImageForCVService imageForCVService;
    private JobSeekerService jobseekerService;

    public ImagesController(ImageForCVService imageForCVService, JobSeekerService jobseekerService) {
        super();
        this.imageForCVService = imageForCVService;
        this.jobseekerService = jobseekerService;
    }


    @PostMapping(value = "/add")
    public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
        JobSeeker jobSeeker = this.jobseekerService.getById(id).getData();
        ImageForCV imageForCV = new ImageForCV();
        imageForCV.setJobSeeker(jobSeeker);
        return this.imageForCVService.add(imageForCV, imageFile);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ImageForCV imageForCV) {
        return this.imageForCVService.update(imageForCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.imageForCVService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<ImageForCV> getById(@RequestParam("id") int id) {
        return this.imageForCVService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ImageForCV>> getAll() {
        return this.imageForCVService.getAll();
    }


    @GetMapping("/getByJobSeekerId")
    public DataResult<ImageForCV> getByJobSeekerId(@RequestParam int id) {
        return this.imageForCVService.getByJobSeekerId(id);
    }
}