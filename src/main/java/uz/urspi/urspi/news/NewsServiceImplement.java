package uz.urspi.urspi.news;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.urspi.urspi.image.Image;
import uz.urspi.urspi.image.ImageService;
import uz.urspi.urspi.storage.StorageService;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImplement implements NewsService {

    private final NewsRepository newsRepository;
    private final StorageService storageService;
    private final ImageService imageService;
    private final UserService userService;


    @Override
    public void createNews(NewsDTO newsDTO) throws Exception {
        String fileName = storageService.store(newsDTO.getImage());
        News news = new News();
        news.setTitle(newsDTO.getTitle());
        news.setAuthor(userService.getCurrentUser().getRole().toString());
        news.setContent(newsDTO.getContent());
        news.setImage(fileName);
        news.setDepartment(newsDTO.getDepartment());
        news.setCategory(newsDTO.getCategory());
        news.setStatus(1);
        News n = newsRepository.save(news);
        if (newsDTO.getSlide1() != null) {
            imageService.saveImage(newsDTO.getSlide1(), n);
        }
        if (newsDTO.getSlide2() != null) {
            imageService.saveImage(newsDTO.getSlide2(), n);
        }
        if (newsDTO.getSlide3() != null) {
            imageService.saveImage(newsDTO.getSlide3(), n);
        }
    }

    @Override
    public void updateNews(NewsDTO newsDTO, Long id) throws Exception {
        News news = newsRepository.findById(id).orElseThrow(null);
        news.setTitle(newsDTO.getTitle());
        news.setAuthor(userService.getCurrentUser().getRole().toString());
        news.setContent(newsDTO.getContent());
        news.setDepartment(newsDTO.getDepartment());
        news.setCategory(newsDTO.getCategory());
        news.setStatus(1);
        if (!newsDTO.getImage().getOriginalFilename().isEmpty()) {
            news.setImage(storageService.store(newsDTO.getImage()));
        }
        List<Image> newsSlides = imageService.fetchImagesByNewsId(id);
        if(!newsDTO.getSlide1().getOriginalFilename().isEmpty()) {
            Image image = newsSlides.get(0);
            imageService.updateImage(image, newsDTO.getSlide1());
        }
        if(!newsDTO.getSlide2().getOriginalFilename().isEmpty()) {
            Image image = newsSlides.get(1);
            imageService.updateImage(image, newsDTO.getSlide2());
        }
        if(!newsDTO.getSlide3().getOriginalFilename().isEmpty()) {
            Image image = newsSlides.get(2);
            imageService.updateImage(image, newsDTO.getSlide3());
        }
    }


    @Override
    public void deleteNews(Long newsId) {
        News news = newsRepository.findById(newsId).orElseThrow(null);
        news.setStatus(0);
        newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public News getNewsById(Long newsId) {
        return newsRepository.findById(newsId).orElseThrow();
    }

    @Override
    public Page<News> fetchPageableNews(Pageable pageable) {
        return newsRepository.findAllByStatus(1, pageable);
    }
}
