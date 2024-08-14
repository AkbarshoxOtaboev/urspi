package uz.urspi.urspi.storage;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;

@ConfigurationProperties("storage")
public class StorageProperties {

    private String uploadsLocation = System.getProperty("user.dir") + "\\uploads\\";
    private String tempLocation = System.getProperty("user.dir") + "\\temp\\";

    public StorageProperties(){
        ApplicationHome home = new ApplicationHome(this.getClass());
        File jarFile = home.getSource();
        File jarDir = home.getDir();
        uploadsLocation = jarDir+"/uploads";
        tempLocation = jarDir+"/temp";
        File uploadDir = new File(jarDir, "uploads");
    }

    public String getUploadsLocation() {
        return uploadsLocation;
    }

    public void setUploadsLocation(String uploadsLocation) {
        this.uploadsLocation = uploadsLocation;
    }

    public String getTempLocation() {
        return tempLocation;
    }

    public void setTempLocation(String tempLocation) {
        this.tempLocation = tempLocation;
    }
}
