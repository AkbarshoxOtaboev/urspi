package uz.urspi.urspi.eventInfo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EventInfoDTO {
    private String name;
    private MultipartFile file;
}
