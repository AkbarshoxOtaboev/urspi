package uz.urspi.urspi.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.urspi.urspi.user.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImplement implements NewsService {

    private final NewsRepository newsRepository;
    private final String UPLOAD_DIRECTORY = System.getProperty("user.dir");

    @Override
    public void createNews(NewsDTO newsDTO) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path  fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, newsDTO.getImage().getOriginalFilename());
        fileNames.append(fileNameAndPath.getFileName().toString());
        Files.write(fileNameAndPath, newsDTO.getImage().getBytes());
        News news = new News();
        news.setTitle(newsDTO.getTitle());
        news.setAuthor(newsDTO.getAuthor());
        news.setContent(newsDTO.getContent());
        news.setImage(fileNames.toString());
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
