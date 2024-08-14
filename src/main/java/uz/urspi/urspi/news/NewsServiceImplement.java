package uz.urspi.urspi.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.urspi.urspi.storage.StorageService;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImplement implements NewsService {

    private final NewsRepository newsRepository;
    private final StorageService storageService;


    @Override
    public void createNews(NewsDTO newsDTO){
        String fileName = storageService.store(newsDTO.getImage());
        News news = new News();
        news.setTitle(newsDTO.getTitle());
        news.setAuthor(newsDTO.getAuthor());
        news.setContent(newsDTO.getContent());
        news.setImage(fileName);
        news.setDepartment(newsDTO.getDepartment());
        news.setCategory(newsDTO.getCategory());
        newsRepository.save(news);

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
