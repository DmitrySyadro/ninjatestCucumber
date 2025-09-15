package feature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void verifyBreadcrumbURlHeadingTitleofRegisterAccountPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        driver.get("https://tutorialsninja.com/demo");
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

        driver.quit();
    }

    public static String generateEmail(){
        return new Date().toString().replaceAll("\\s","").replaceAll(":", "_") + "@gmail.com";
    }
}

