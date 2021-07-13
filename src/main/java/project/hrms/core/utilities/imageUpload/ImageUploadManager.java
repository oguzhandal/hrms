package project.hrms.core.utilities.imageUpload;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadManager implements ImageUploadService {

    private Cloudinary cloudinary;

    public ImageUploadManager() {

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "da3jvg901",
                "api_key", "934795712178158",
                "api_secret", "tiYAOOxBOLtoP_22wvzRoVGs1Xc"));
    }

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(resultMap);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return new ErrorDataResult<Map>();
    }

}