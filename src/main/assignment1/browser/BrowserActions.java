package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {
    public WebDriver driver;
    public void launchChrome(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver=new ChromeDriver();
        System.out.println("Chrome launched successfully");
        //  return driver;
    }

    public void launchFirefox(){
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver=new FirefoxDriver();
        System.out.println("Firefox launched successfully");
    }

    public void launchApplication(String appUrl)  {
        try{
            driver.manage().window().maximize();
            driver.get(appUrl);
            driver.navigate().refresh();
            Thread.sleep(3000);
        }
        catch (Exception e){
            System.out.println("Caught the issue in application launching");
            e.printStackTrace();
        }

        //return driver;
    }

    public void closeBrowser(){
        driver.close();
        System.out.println("Browser closed successfully");
    }


}
