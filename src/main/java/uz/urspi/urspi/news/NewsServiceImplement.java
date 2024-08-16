package uz.urspi.urspi.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    private final UserService  userService;


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
        News n = newsRepository.save(news);
        if(newsDTO.getSlide1()!=null){
            imageService.saveImage(newsDTO.getSlide1(), n);
        }
        if(newsDTO.getSlide2()!=null){
            imageService.saveImage(newsDTO.getSlide2(), n);
        }
        if(newsDTO.getSlide3()!=null){
            imageService.saveImage(newsDTO.getSlide3(), n);
        }

    }

    @Override
    public void updateNews(NewsDTO newsDTO, Long newsId) {

    }

    @Override
    public void deleteNews(Long newsId) {

    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long newsId) {
        return newsRepository.findById(newsId).orElseThrow();
    }
}
