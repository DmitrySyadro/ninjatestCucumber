package feature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup(){
        String browsername = "firefox";
        String browserChro = "chrome";
        if(browsername.equals("firefox")){
            driver = new FirefoxDriver();
        }else if(browserChro.equals("chrome")){
            driver = new ChromeDriver();
        }

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo");
    }

    @AfterMethod
    public void teardown(){
        if(driver!=null) {
            driver.quit();
        }
    }


    @Test(priority = 1)
    public void verifyBreadcrumbURlHeadingTitleofRegisterAccountPage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        homePage.clickOnMyAccount();
        homePage.clickReg();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        String expectedHeading = "Register Account";
        String actualHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualHeading, expectedHeading);


        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


        String expectedTitle = "Register Account";
        Assert.assertEquals(driver.getTitle(), expectedTitle);


    }

    public static String generateEmail(){
        return new Date().toString().replaceAll("\\s","").replaceAll(":", "_") + "@gmail.com";
    }
}

