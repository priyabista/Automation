package TestFileUploadsPackage;
import drivers.DriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Locators;
import utils.ConfigReader;
import reusable.Reusable;

public class Zamzar {

private static WebDriver driver;
private Reusable reusable;
private static final String Zamzar_url = "https://www.zamzar.com/";

    @BeforeEach
    public void setDriver(){
        driver = DriverFactory.initDriver();
        reusable = new Reusable(driver);
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
                    upload_files(driver, filePathe, "docx");
                    break;
            }
        }
    }
    public void upload_files(WebDriver driver, String filePath, String extensions){
        WebElement upload_btn = reusable.waitForPresence((Locators.UPLOAD_INPUT));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].classList.remove('d-none');", upload_btn);
        System.out.println(filePath);
        upload_btn.sendKeys(filePath);
    }


}
