package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.ConfigerReader;

import java.time.Duration;
import java.util.Properties;

public class Hook1 {
    private static WebDriver driver;
    private static boolean initialized = false;

    @Before(order = 1)
    public void setup() {
        if (!initialized) {
            Properties prop = ConfigerReader.intializeproperties();
            DriverFactory.initializeBrowser("firefox");
            driver = DriverFactory.getDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            initialized = true;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Make sure @Before hooks run first.");
        }
        return driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioname = scenario.getName().replace(" ", "_");
        if(driver != null) {
            if (scenario.isFailed()) {
                byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(srcScreenshot, "image/png", scenarioname);
            }

        }
    }

    @After(order = 1000) // Виконається останнім
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
            initialized = false;
        }
    }

    @Before(value = "@LoginRequired", order = 10)
    public void the_user_is_logged_into_the_website() {
        BasePage basePage = new BasePage(driver);
        basePage.login("dmytro.syadro@gmail.com", "11111111");
    }
}