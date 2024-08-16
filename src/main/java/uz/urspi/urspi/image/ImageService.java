package uz.urspi.urspi.image;

import org.springframework.web.multipart.MultipartFile;
import uz.urspi.urspi.news.News;

import java.util.List;

public interface ImageService {
    void saveImage(MultipartFile imageFile, News news) throws Exception;
    List<Image> fetchImagesByNewsId(Long newsId);
}
