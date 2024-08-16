package uz.urspi.urspi.image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.urspi.urspi.config.TableName;
import uz.urspi.urspi.news.News;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.IMAGES)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "news_id")
    private News news;
}
