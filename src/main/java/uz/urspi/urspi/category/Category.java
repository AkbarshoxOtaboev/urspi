package uz.urspi.urspi.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import uz.urspi.urspi.news.News;
import uz.urspi.urspi.config.TableName;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableName.CATEGORIES)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer status;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private List<News> news;

    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

}
