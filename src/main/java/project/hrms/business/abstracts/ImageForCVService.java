package project.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ImageForCV;

import java.util.List;

public interface ImageForCVService {
    Result add(ImageForCV imageForCV, MultipartFile imageFile);

    Result update(ImageForCV imageForCV);

    Result delete(int id);

    DataResult<ImageForCV> getById(int id);

    DataResult<List<ImageForCV>> getAll();

    DataResult<ImageForCV> getByJobSeekerId(int id);
}
