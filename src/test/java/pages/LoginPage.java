package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement clickontheLoginButton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement getproperwarningmessage;
    @FindBy(id = "input-email")
    private WebElement email1;
    @FindBy(id = "input-password")
    private WebElement password1;


    public void Emailsend(String emailTimesStamp){
        email.sendKeys("dmytro.syadro@gmail.com");
    }
    public void Passwordsend(String emailTimesStamp){
        password.sendKeys("11111111");
    }
    public void email1(){
        email1.sendKeys("dddd222@gmail.com");
    }
    public void password1(){
        password1.sendKeys("222222");
    }
    public AccountPage ClickLogin(){
        clickontheLoginButton.click();
        return new AccountPage(driver);
    }
    public boolean thepropermessage(){
        getproperwarningmessage.isDisplayed();
        return false;
    }

}
