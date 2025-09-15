package pages;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class HomePage {
    public ElementUtils elementUtils;
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils();

    }
    @FindBy (xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;
    @FindBy(linkText = "Login")
    private WebElement Loginicon;
    @FindBy(linkText = "Register")
    private WebElement Registericon;
    @FindBy(xpath = "//ul[@class=''breadcrumb']//a[text()='Register']")
    private WebElement AssertRegisterCrumb;

    public void clickOnMyAccount(){
        myAccountDropMenu.click();

    }
    public LoginPage clickonLoginOption(){
        Loginicon.click();
        return new LoginPage(driver);
    }
    public LoginPage clickReg(){
        Registericon.click();
        return new LoginPage(driver);
    }

}
