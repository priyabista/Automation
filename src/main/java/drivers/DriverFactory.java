package drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory{
   private static WebDriver driver;

   public static WebDriver initDriver(){
       System.setProperty("webdriver.edge.driver",
               System.getProperty("user.dir") + "/src/main/java/drivers/msedgedriver.exe");
       driver = new EdgeDriver();
       driver.manage().window().maximize();
       return driver;

   }
   public static WebDriver getDriver(){
       return driver;
   }
   public static void quitDriver(){
       if(driver != null){
             driver.quit();
       }
   }

}