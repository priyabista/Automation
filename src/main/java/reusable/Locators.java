package reusable;

public class Locators {
    public static final String FORMAT_DROPDOWNS = "//select[starts-with(@id,'tafmt_')]";

    public static final String DOWNLOAD_BUTTON =
            "(//*[contains(normalize-space(),'Download')])[1]";

    public static final String ADVANCED_BUTTON = "/html/body/div/div[2]/button[3]";
    public static final String CONTINUE_LINK = "/html/body/div/div[3]/p[2]/a";
    
    public static final String UPLOAD_INPUT = "//input[@type='file']";
    public static final String START_CONVERTING_BUTTON = "(//div[@class='btn_convert conv_start'])[1]";
    public static final String CONVERT_BUTTON = "(//button[@data-automation-id='FileInputDropdownFileConvert'])";
    public static final String NITRO_UPLOAD_FILES = "input[type='file']";
    public static final String AddFiles_Btn_AConvert = "//div[contains(@class,'moxie-shim')]//input[@type='file']";

}