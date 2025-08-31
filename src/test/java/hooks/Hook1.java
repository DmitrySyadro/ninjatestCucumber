package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigerReader;

import java.time.Duration;
import java.util.Properties;

public class Hook1 {
    WebDriver driver;
    @Before
    public void setup() {
        Properties prop = ConfigerReader.intializeproperties();
        DriverFactory.initializeBrowser("firefox");
        driver = DriverFactory.getDriver();
        }
        @After
        public void tearDown(Scenario scenario){
        String scenarioname = scenario.getName().replace(" ", "_");
        if(scenario.isFailed()){
            byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenshot, "image/png", scenarioname);

        }


        driver.quit();



        }


    }
