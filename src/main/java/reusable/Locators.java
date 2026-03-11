package reusable;

import org.openqa.selenium.By;

public class Locators {
    public static final String FORMAT_DROPDOWNS = "//select[starts-with(@id,'tafmt_')]";
    public static final By DOWNLOAD_BUTTON = By.xpath("(//*[contains(normalize-space(),'Download')])[1]");
    public static final String ADVANCED_BUTTON = "/html/body/div/div[2]/button[3]";
    public static final String CONTINUE_LINK = "/html/body/div/div[3]/p[2]/a";
    public static final By UPLOAD_INPUT = By.xpath("//input[@type='file']");
    public static final By ZAMZAR_NAVIGATION_BAR = By.xpath("//*[@id=\"home\"]/header/nav/div");
    public static final String START_CONVERTING_BUTTON = "(//div[@class='btn_convert conv_start'])[1]";
    public static final By FILE_LIST = By.xpath("//div[@id='FileInputDropdown']");
    public static final String FC_Convert_button = "//button[@class='button primary file-input-dropdown__action__convert']";
    public static final String NITRO_UPLOAD_FILES = "input[type='file']";
    public static final String AddFiles_Btn_AConvert = "//div[contains(@class,'moxie-shim')]//input[@type='file']";
    // Locators for Zamzar website only
    public static final By ZAMZAR_FILE_LIST = By.id("file-list");
    public static final By ZAMZAR_CONVERT_BTN = By.id("options-apply-settings");
    public static final By  convertBtn = By.id("convert");


}