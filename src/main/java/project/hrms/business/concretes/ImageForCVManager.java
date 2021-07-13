package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.ImageForCVService;
import project.hrms.core.utilities.imageUpload.ImageUploadService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ImageForCVDao;
import project.hrms.entities.concretes.ImageForCV;


import java.util.List;
import java.util.Map;

@Service
public class ImageForCVManager implements ImageForCVService {

    private ImageForCVDao imageForCVDao;
    private ImageUploadService imageUploadService;

    @Autowired
    public ImageForCVManager(ImageForCVDao imageForCVDao, ImageUploadService imageUploadService) {
        super();
        this.imageForCVDao = imageForCVDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public Result add(ImageForCV imageForCV, MultipartFile imageFile) {
        Map<String, String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
        imageForCV.setUrl(uploadImage.get("url"));
        this.imageForCVDao.save(imageForCV);
        return new SuccessResult("Image has been added.");
    }

    @Override
    public Result update(ImageForCV imageForCV) {
        this.imageForCVDao.save(imageForCV);
        return new SuccessResult("Image has been updated.");
    }

    @Override
    public Result delete(int id) {
        this.imageForCVDao.deleteById(id);
        return new SuccessResult("Image has been deleted.");
    }

    @Override
    public DataResult<ImageForCV> getById(int id) {
        return new SuccessDataResult<ImageForCV>(this.imageForCVDao.getById(id));
    }

    @Override
    public DataResult<List<ImageForCV>> getAll() {
        return new SuccessDataResult<List<ImageForCV>>(this.imageForCVDao.findAll());
    }

    @Override
    public DataResult<ImageForCV> getByJobSeekerId(int id) {
        return new SuccessDataResult<ImageForCV>(this.imageForCVDao.getByJobSeeker_id(id));
    }

}