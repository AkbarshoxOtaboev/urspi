package uz.urspi.urspi.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.urspi.urspi.category.Category;

public interface NewsRepository extends JpaRepository<News, Long> {
    Page<News> findAllByCategory(Category category, Pageable pageable);
}
