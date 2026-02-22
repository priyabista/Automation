package reusable;

public class Locators {
    public static final String FORMAT_DROPDOWNS = "//select[starts-with(@id,'tafmt_')]";

    public static final String DOWNLOAD_BUTTON =
            "/html/body/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/a";

    public static final String ADVANCED_BUTTON = "/html/body/div/div[2]/button[3]";
    public static final String CONTINUE_LINK = "/html/body/div/div[3]/p[2]/a";

    // Example if you have an upload input
    public static final String UPLOAD_INPUT = "//input[@type='file']";
    public static final String START_CONVERTING_BUTTON = "(//div[@class='btn_convert conv_start'])[1]";
    public static final String CONVERT_BUTTON = "(//button[@data-automation-id='FileInputDropdownFileConvert'])";
    public static final String NITRO_UPLOAD_FILES = "input[type='file']";

}