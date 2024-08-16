package uz.urspi.urspi.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.urspi.urspi.news.News;
import uz.urspi.urspi.storage.StorageService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImplement implements ImageService {

    private final ImageRepository imageRepository;
    private final StorageService storageService;
    @Override
    public void saveImage(MultipartFile imageFile, News news) throws IOException {
        String imageName = storageService.store(imageFile);
        Image image = new Image();
        image.setPath(imageName);
        image.setNews(news);
        imageRepository.save(image);

    }

    @Override
    public List<Image> fetchImagesByNewsId(Long newsId) {
        return imageRepository.findAllByNewsId(newsId);
    }
}
