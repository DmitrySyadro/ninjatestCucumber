package feature;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.apache.commons.logging.Log;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {

    WebDriver driver;
    private LoginPage loginPage;
    private AccountPage accountPage;




    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver = DriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        loginPage = homePage.clickonLoginOption();
    }

    @When("User has entered the valid email into the email field {string}")
    public void user_has_entered_the_valid_email_into_the_email_field(String email) {
        loginPage.Emailsend(CommonUtils.getEmailTimesStamp());
    }

    @When("User has entered the valid password into the password field {string}")
    public void user_has_entered_the_valid_password_into_the_password_field(String password) {
        loginPage.Passwordsend(CommonUtils.getEmailTimesStamp());
    }

    @When("User has entered the invalid email into the email field {string}")
    public void user_has_entered_the_invalid_email_into_the_email_field(String email1) {
        loginPage.email1();
    }

    @When("User has entered the invalid password into the password field {string}")
    public void user_has_entered_the_invalid_password_into_the_password_field(String password1) {
        loginPage.password1();
    }

    @When("User has clicked on the Login button")
    public void user_has_clicked_on_the_login_button() {
        accountPage = loginPage.ClickLogin();
    }

    @Then("User should be redirected to the successful page logged in")
    public void user_should_be_redirected_to_the_successful_page_logged_in() {
        Assert.assertTrue(accountPage.EditYourInfassert());
    }

    @Then("The error message should be displayed below the fields")
    public void the_error_message_should_be_displayed_below_the_fields() {
        SoftAssertions softly = new SoftAssertions();
        //Assert.assertTrue(loginPage.thepropermessage());
        String expectedresult = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals(expectedresult, actualresult);
        softly.assertAll();
    }



}
