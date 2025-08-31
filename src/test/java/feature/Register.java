package feature;

import factory.DriverFactory;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.StdDateFormat;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v137.fedcm.model.AccountUrlType;
import pages.AccountSuccessfulPage;
import utils.CommonUtils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class Register {

    WebDriver driver;

    @Given("A User navigates to the register account page")
    public void a_user_navigates_to_the_register_account_page() {
        driver = DriverFactory.getDriver();
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @When("A user enters the details into the fields")
    public void a_user_enters_the_details_into_the_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getEmailTimesStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("passwordconfirmation"));



    }

    @When("A user enters the details into the fields with a duplicate email")
    public void a_user_enters_the_details_into_the_fields_with_a_duplicate_email(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("passwordconfirmation"));
    }

    @When("A user selects Privacy Policy")
    public void a_user_selects_privacy_policy() {
        driver.findElement(By.xpath("//input[@name='agree']")).click();
    }

    @When("A user clicks on the Continue button")
    public void a_user_clicks_on_the_continue_button() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("A user's account should be created successfully")
    public void a_user_s_account_should_be_created_successfully() {
        AccountSuccessfulPage successfulPage = new AccountSuccessfulPage(driver);
        Assert.assertEquals("Your Account Has Been Created!", successfulPage.assertyouracc());
    }

    @When("A user selects Yes for Newsletter")
    public void a_user_selects_yes_for_newsletter() {
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
    }

    @When("A user doesn't enter any details into fields")
    public void a_user_doesn_t_enter_any_details_into_fields() {

    }

    @Then("A user should be proper warning message for every mandatory field")
    public void a_user_should_be_proper_warning_message_for_every_mandatory_field() {
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
        Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText());
        Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText());
        Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText());

    }

    @Then("A user's account should get a proper warning that the account with those credentials was created")
    public void a_user_s_account_should_get_a_proper_warning_that_the_account_with_those_credentials_was_created() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
    }



}
