package TestFileUploadsPackage;

import drivers.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Reusable;
import reusable.Locators;
import utils.ConfigReader;
import java.io.File;

public class SmallPdf {
    private WebDriver driver;
    private Reusable reusable;

    @BeforeEach
    public void setDriver()
    {

        driver = DriverFactory.initDriver();
        reusable = new Reusable(driver);
    }
    private String getUrlByExtension(String filePath)
    {

        File f = new File(filePath);
        if (!f.exists()) {
            throw new RuntimeException("File does not exist: " + filePath);
        }
        String ext = filePath.substring(filePath.lastIndexOf(".") + 1);

        //System.out.println(ext);
        return switch (ext) {
            case "doc","docx" -> "https://smallpdf.com/word-to-pdf";
            case "pdf" -> "https://smallpdf.com/pdf-to-word";
            case "xlsx" -> "https://smallpdf.com/excel-to-pdf";
            default -> throw new RuntimeException("Unsupported file extension: " + ext);
        };

    }

    public void uploadFile(String  filePath){
         String url = getUrlByExtension(filePath);
         Allure.step("Opening tool" + url);
         driver.get(url);

        Allure.step("Waiting for upload input");
        WebElement uploadInput = reusable.waitForPresence(Locators.UPLOAD_INPUT);

        Allure.step("uploading file: " + new File(filePath).getName());
        uploadInput.sendKeys(filePath);

        Allure.step("Waiting for Download button (conversion finished) ");
        WebElement downloadBtn = reusable.waitForDownloadButton(Locators.DOWNLOAD_BUTTON);

    }

    @Description("Uploads multiple file types to small pdf one by one.")

    @Test
    public void uploadSingleFile() {

        String[] files = {
                ConfigReader.getFilePath("word.file"),
                ConfigReader.getFilePath("pdf.file"),
                ConfigReader.getFilePath("excel.file"),
        };

        for(String file : files){
            uploadFile(file);
        }
    }
}

