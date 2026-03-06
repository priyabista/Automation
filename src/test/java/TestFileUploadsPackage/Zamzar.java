package TestFileUploadsPackage;
import drivers.DriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Locators;
import utils.ConfigReader;

public class Zamzar {

private static WebDriver driver;
private static final String Zamzar_url = "https://www.zamzar.com/";

    @BeforeEach
    public void setDriver(){
        driver = DriverFactory.initDriver();
        driver.get(Zamzar_url);
    }
    @Test
    public void get_filePaths(){
        String [] filePaths = {
                ConfigReader.getFilePath("word.file"),
                ConfigReader.getFilePath("pdf.file"),
                ConfigReader.getFilePath("excel.file"),
                ConfigReader.getFilePath("csv.file"),
                ConfigReader.getFilePath("jpg.file")
        };
        for(String filePathe : filePaths){
            String extensions = filePathe.substring(filePathe.lastIndexOf('.') + 1);
            switch (extensions){
                case "docx":
                    upload_files(filePathe);
            }
        }
    }
    public void upload_files(String filePath){
        WebElement upload_btn = driver.findElement(By.xpath(Locators.Zam_Choose_file_btn));
        System.out.println(filePath);
        upload_btn.sendKeys(filePath);
    }


}
