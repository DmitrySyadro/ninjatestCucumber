package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.ConfigerReader;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver = null;
    public static WebDriver initializeBrowser(String browserName){
        Properties prop = ConfigerReader.intializeproperties();

        if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }
        else if(browserName.equals("safari")){
            driver = new SafariDriver();
        }


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String appURL = prop.getProperty("url");
        driver.get(appURL);
        return driver;

    }

    public static WebDriver getDriver(){
        return driver;
    }
}



