package project.hrms.core.utilities.imageUpload;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;

import java.util.Map;

public interface ImageUploadService {
    DataResult<Map> uploadImageFile(MultipartFile imageFile);

}
