package uz.urspi.urspi.news;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    void createNews(NewsDTO newsDTO) throws Exception;

    void updateNews(NewsDTO newsDTO, Long newsId);

    void deleteNews(Long newsId);

    List<News> getAllNews();

    News getNewsById(Long newsId);
}
