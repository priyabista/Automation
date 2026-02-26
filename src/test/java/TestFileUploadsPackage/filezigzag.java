package TestFileUploadsPackage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import reusable.Locators;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Reusable;
import utils.ConfigReader;
import drivers.DriverFactory;

import java.io.File;

public class filezigzag {
    private WebDriver driver;
    private Reusable reusable;
    private static final String upload_url = "https://www.filezigzag.com/";

    @BeforeEach
    public void setDriver() {
        driver = DriverFactory.initDriver();
        reusable = new Reusable(driver);
    }

    @Test
    public void HandleConnectionSecure(){
        Allure.step("Opening website" + upload_url);
        driver.get(upload_url);
        reusable.clickAdvancedAndContinueButton();
    }

    public void uploadFile(String filePath){
        Allure.step("Waiting for upload input");
        WebElement uploadInput = reusable.waitForPresence(Locators.UPLOAD_INPUT);

        Allure.step("uploading file: " + new File(filePath).getName());

        uploadInput.sendKeys(filePath);

    }

    @Test
    @Description("Uploads multiple file types at once")
    public void uploadMultipleFiles() {
        HandleConnectionSecure();
        String[] files = {
                ConfigReader.getFilePath("word.file"),
                ConfigReader.getFilePath("pdf.file"),
                ConfigReader.getFilePath("excel.file"),
                ConfigReader.getFilePath("csv.file"),
                ConfigReader.getFilePath("jpg.file"),
        };

        for(String file : files){
            uploadFile(file);
        }
        String[] formats = {"DOC", "DOCX", "CSV", "XLSX", "PDF"};
        reusable.selectFormat(formats);
        WebElement startConverting = driver.findElement(By.xpath(Locators.START_CONVERTING_BUTTON));
        startConverting.click();
        }

    }


