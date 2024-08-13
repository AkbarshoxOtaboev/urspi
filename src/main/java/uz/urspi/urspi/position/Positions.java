package uz.urspi.urspi.position;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import uz.urspi.urspi.config.TableName;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableName.POSITIONS)
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer status;

    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;
}
