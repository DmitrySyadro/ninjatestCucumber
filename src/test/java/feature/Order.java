package feature;

import Base.base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order {
    WebDriverWait wait;
    WebDriver driver;

    @Given("The user login in the app")
    public void the_user_login_in_the_app() {
        base.driver.get(arg0);
    }

    @When("The user add any product to back and checkout")
    public void the_user_add_any_product_to_back_and_checkout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user place an order")
    public void the_user_place_an_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The user should see that order is places successfully")
    public void the_user_should_see_that_order_is_places_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
