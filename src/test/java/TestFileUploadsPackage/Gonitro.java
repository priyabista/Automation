package TestFileUploadsPackage;

import drivers.DriverFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Reusable;
import utils.ConfigReader;
import java.io.File;
import reusable.Locators;

public class Gonitro {
    private WebDriver driver;
    private Reusable reusable;

    @BeforeEach
    public void setDriver(){

        driver = DriverFactory.initDriver();
        reusable = new Reusable(driver);
    }
    @AfterEach
    public void closeDriver(){
        DriverFactory.quitDriver();
    }

    private String getUrlByExtension(String filePath) {
       File file = new File(filePath);
       if(!file.exists()){
           throw  new RuntimeException("File does not exist" + filePath);
       }
       String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
       return switch (extension) {
           case "docx" -> "https://www.gonitro.com/word-to-pdf";
           case "pdf" -> "https://www.gonitro.com/pdf-to-word";
           case "xlsx" -> "https://www.gonitro.com/excel-to-pdf";
           case "jpg" ->  "https://www.gonitro.com/image-to-pdf";
           default -> throw new RuntimeException("Unsupported file extension " + extension);
       };
    }
    public void uploadFile(String filePath) {
        String url = getUrlByExtension(filePath);
        Allure.step("Opening website" + url);
        driver.get(url);
        Allure.step("Waiting for upload input");
        WebElement fileInputSend = reusable.handle_shadowDOM_element();
        // Step 4: Upload file
        fileInputSend.sendKeys(filePath);


    }
    @Test
    public void uploadSingleFile() {

        String[] files = {
                ConfigReader.getFilePath("word.file"),
                ConfigReader.getFilePath("pdf.file"),
                ConfigReader.getFilePath("excel.file"),
                ConfigReader.getFilePath("jpg.file"),
        };

        for(String file : files){
            uploadFile(file);
        }
    }

}
