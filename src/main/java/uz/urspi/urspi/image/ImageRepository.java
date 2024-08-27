package uz.urspi.urspi.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "select * from images where news_id = ?1 order by id asc", nativeQuery = true)
    List<Image> findAllByNewsId(Long id);
}
