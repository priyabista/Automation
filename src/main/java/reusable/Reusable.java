package reusable;
import drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class Reusable {
    private WebDriver driver;
    private WebDriverWait wait;

    public Reusable(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForPresence(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement waitForDownloadButton(String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void clickAdvancedAndContinueButton() {

        WebElement btnOne = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.ADVANCED_BUTTON)));

        if(btnOne != null) {
            btnOne.click();
        }

        WebElement btnTwo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.CONTINUE_LINK)));

        if(btnTwo != null) {
            btnTwo.click();
        }

    }

    public void selectFormat(String[] formats) {

        List<WebElement> dropdowns = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Locators.FORMAT_DROPDOWNS)));

        if(dropdowns != null){
            int count = Math.min(dropdowns.size(), formats.length);

            for(int i=0; i< count; i++){
                new Select(dropdowns.get(i)).selectByVisibleText(formats[i]);
            }
        }

    }
    public WebElement handle_shadowDOM_element(){
        WebElement host = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ncc-file-type-conversion-workflow")));

        // Step 2: Get shadow root
        SearchContext shadowRoot = host.getShadowRoot();

        // Step 3: Locate file input inside shadow DOM
        WebElement fileInput = shadowRoot.findElement(By.cssSelector(Locators.NITRO_UPLOAD_FILES));
        return fileInput;

    }
    public WebElement getAconvertUploadInput() {
        WebElement containerElement = driver.findElement(By.id("uploader_container"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", containerElement);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.AddFiles_Btn_AConvert)));
    }

    public WebElement Check_FC_File_List_Bottom_Bar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.FC_Wait_For_File_List_Bottom_Bar)));
    }

    public WebElement Handle_FC_Convert_Button() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.FC_Convert_button)));
        return  button;
    }
}
