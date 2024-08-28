package uz.urspi.urspi.eventInfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.urspi.urspi.config.TableName;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.EVENT_INFOS)
public class EventInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String path;
}
