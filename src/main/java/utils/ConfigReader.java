package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream("src/resources/file.properties");
            properties = new Properties();
            properties.load(fis);

        } catch (Exception e) {
             throw new RuntimeException("Fail to load file properties", e);
        }
    }
    public static String getFilePath(String key) {
        String basePath = System.getProperty("user.dir") + "/" + properties.getProperty("upload.base.path");
        return basePath + properties.getProperty(key);
    }
}
