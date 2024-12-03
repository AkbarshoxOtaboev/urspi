package uz.urspi.urspi.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    void createNews(NewsDTO newsDTO) throws Exception;

    void updateNews(NewsDTO newsDTO, Long id) throws Exception;

    void deleteNews(Long newsId);

    List<News> getAllNews();

    News getNewsById(Long newsId);

    Page<News> fetchPageableNews (Integer status, Pageable pageable);
}
