package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SortBy {
    WebDriver driver;

    public SortBy(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement clickComponents;


    public void clickOnComponentsAndSelect(){
        WebElement element = driver.findElement(By.xpath(String.valueOf(clickComponents)));
        Select select = new Select(element);
        select.selectByVisibleText("");


    }

}
