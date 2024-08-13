package uz.urspi.urspi.news;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import uz.urspi.urspi.category.Category;
import uz.urspi.urspi.config.TableName;
import uz.urspi.urspi.department.Department;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = TableName.NEWS)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String author;

    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;


    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

}
