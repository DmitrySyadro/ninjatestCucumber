package utils;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    WebDriver driver;
    public void ClickonaElement(WebElement element, long durationInSeconds){
        this.driver = driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element.click();
    }
    public void Typetextintothefield(WebElement element, String textobetypeed, long durationinSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
        WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
        webelement.click();
        webelement.clear();
        webelement.sendKeys(textobetypeed);
    }
    public WebElement waitForElement(WebElement element, long durationinseconds){
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
            webElement =  wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch(Throwable e){
            e.printStackTrace();
        }
        return webElement;
    }

    public void SelectOptionDropDown(WebElement element, String dropDownOption,long durationinSeconds){
        WebElement webElement = waitForElement(element,durationinSeconds);
        Select select = new Select(element);
        select.selectByVisibleText(dropDownOption);
    }
    public void dismissalert(long durationinseconds){
        Alert alert = waitforalert(durationinseconds);
        alert.dismiss();
    }
    public void acceptalert(long durationinseconds){
        Alert alert = waitforalert(durationinseconds);
        alert.accept();
    }
    public Alert waitforalert(long durationinseconds){
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        }catch (Throwable e){
            e.printStackTrace();
        }
        return alert;
    }
    public void mousehoverandclick(WebElement element, long durationinseconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinseconds));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement)
                .click()
                .build()
                .perform();
    }
}
