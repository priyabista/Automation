package TestFileUploadsPackage;

import drivers.DriverFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import reusable.Locators;
import reusable.Reusable;
import utils.ConfigReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AConvert {

        private WebDriver driver;
        private Reusable reusable;

        @BeforeEach
        public void setDriver(){
            driver = DriverFactory.initDriver();
            reusable =  new Reusable(driver);
        }
        @AfterEach
        public void closeDriver(){
            DriverFactory.quitDriver();
        }
        @Test
        public  void getFilesToUpload() {
            driver.get("https://www.aconvert.com/");
            List<String> filePaths = new ArrayList<>(List.of(
               ConfigReader.getFilePath("word.file"),
               ConfigReader.getFilePath("pdf.file"),
               ConfigReader.getFilePath("excel.file"),
               ConfigReader.getFilePath("csv.file"),
               ConfigReader.getFilePath("jpg.file")
            ));

            for (String filePath : filePaths) {
               String extension = filePath.substring(filePath.lastIndexOf('.') + 1);
               switch (extension) {
                   case "docx":
                       Allure.step("Uploading word file");
                       uploadFiles(driver, filePath, "docx");
                       break;
                   case "pdf":
                       Allure.step("Uploading pdf file");
                       uploadFiles(driver, filePath, "pdf");
                       break;
                   case "xlsx":
                       Allure.step("Uploading xlsx file");
                       uploadFiles(driver, filePath, "xlsx");
                       break;
                   case "csv":
                       Allure.step("Uploading csv file");
                       uploadFiles(driver, filePath, "csv");
                       break;
                   case "jpg":
                       Allure.step("Uploading jpg file");
                       uploadFiles(driver, filePath, "jpg");
                       break;
                   default:
                       System.out.println("Unsupported file type " + filePaths);
                       break;
               }
            }
            driver.quit();
        }

    public void uploadFiles(WebDriver driver, String filePath, String extension) {
        WebElement fileInput = reusable.test();
        fileInput.sendKeys(filePath);  // Works even if element is hidden
    }

}
