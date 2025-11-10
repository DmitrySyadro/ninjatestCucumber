package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String email, String password){
        driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();


    }
}
