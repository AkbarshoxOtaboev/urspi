package uz.urspi.urspi.news;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import uz.urspi.urspi.category.Category;
import uz.urspi.urspi.department.Department;

@Data
public class NewsDTO {
    private String title;
    private String content;
    private String author;
    private MultipartFile image;
    private Department department;
    private Category category;
}
