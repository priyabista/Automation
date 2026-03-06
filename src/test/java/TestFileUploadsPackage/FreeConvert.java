package TestFileUploadsPackage;

import drivers.DriverFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Reusable;
import reusable.Locators;
import utils.ConfigReader;

import java.io.File;

public class FreeConvert {
    private WebDriver driver;
    private Reusable reusable;
    private static final String upload_url = "https://www.freeconvert.com/";

    @BeforeEach
    public void setDriver() {

        driver = DriverFactory.initDriver();
        reusable = new Reusable(driver);
    }

    @Test
    public void uploadMultipleFiles() {
        Allure.step("Opening FreeConvert website");
        driver.get(upload_url);
        String[] files = {
                ConfigReader.getFilePath("word.file"),
                ConfigReader.getFilePath("pdf.file"),
                ConfigReader.getFilePath("excel.file"),
                ConfigReader.getFilePath("csv.file"),
                ConfigReader.getFilePath("jpg.file"),
        };

        String allFiles = String.join("\n", files);
        WebElement uploadInput = reusable.waitForPresence(Locators.UPLOAD_INPUT);
        Allure.step("Uploading files " + new File(allFiles).getName());
        uploadInput.sendKeys(allFiles);

        reusable.Check_FC_File_List_Bottom_Bar();
        WebElement button_to_click = reusable.Handle_FC_Convert_Button();
        button_to_click.click();

    }
}
