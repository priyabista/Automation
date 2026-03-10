package TestFileUploadsPackage;
import drivers.DriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusable.Locators;
import utils.ConfigReader;
import reusable.Reusable;

import java.time.Duration;

public class Zamzar {

private static WebDriver driver;
private Reusable reusable;
private static final String Zamzar_url = "https://www.zamzar.com/";

    @BeforeEach
    public void setDriver(){
        driver = DriverFactory.initDriver();
        reusable = new Reusable(driver);
        driver.get(Zamzar_url);
        WebElement element = reusable.waitForPresence(Locators.ZAMZAR_NAVIGATION_BAR);
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
                    upload_files(driver, filePath, "docx");
                    break;
                case "pdf":
                    upload_files(driver, filePath, "pdf");
                    break;
                case "xlsx":
                    upload_files(driver, filePath, "xlsx");
                    break;
                case "csv":
                    upload_files(driver, filePath, "csv");
                    break;
                case "jpg":
                    upload_files(driver, filePath, "jpg");
                    break;
                default:
                    System.out.println("Unsupported file type " + filePaths);
                    break;
            }
        }
    }
    public void upload_files(WebDriver driver, String filePath, String extensions){
        WebElement upload_btn = driver.findElement(By.cssSelector("input[type='file'][multiple]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.display='block';", upload_btn);


        upload_btn.sendKeys(filePath);
        reusable.waitForElementById(Locators.ZAMZAR_FILE_LIST);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='format']")));
        dropdown.selectByValue("doc");
        WebElement settings_popup = reusable.waitForPresence(By.className("modal-dialog"));
        WebElement convertNow_btn = reusable.waitForPresence(Locators.ZAMZAR_CONVERT_BTN);

    }
}
