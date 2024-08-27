package uz.urspi.urspi.news;

import java.util.List;

public interface NewsService {
    void createNews(NewsDTO newsDTO) throws Exception;

    void updateNews(NewsDTO newsDTO, Long id) throws Exception;

    void deleteNews(Long newsId);

    List<News> getAllNews();

    News getNewsById(Long newsId);
}
