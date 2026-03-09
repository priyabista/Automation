package TestFileUploadsPackage;

import drivers.DriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Locators;
import reusable.Reusable;
import utils.ConfigReader;

public class Convertio {
    private static WebDriver driver;
    private Reusable reusable;
    private static final String convertio_url = "https://convertio.co/";

    @BeforeEach
    public void setDriver(){
        driver = DriverFactory.initDriver();
        //reusable = new Reusable(driver);
        driver.get(convertio_url);
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
        for(String filePath : filePaths){
            String extensions = filePath.substring(filePath.lastIndexOf('.') + 1);
            switch (extensions){
                case "docx":
                    findFileUploadInput(driver, filePath, "docx");
                    break;
                case "pdf":
                    findFileUploadInput(driver, filePath, "pdf");
                    break;
                case "xlsx":
                    findFileUploadInput(driver, filePath, "xlsx");
                    break;
                case "csv":
                    findFileUploadInput(driver, filePath, "csv");
                    break;
                case "jpg":
                    findFileUploadInput(driver, filePath, "jpg");
                    break;
                default:
                    System.out.println("Unsupported file type " + filePaths);
                    break;
            }
        }
    }

    public void findFileUploadInput(WebDriver driver, String filePath, String extensions){
        WebElement upload_btn = driver.findElement(By.xpath(Locators.UPLOAD_INPUT));
        upload_btn.sendKeys(filePath);
    }
}
