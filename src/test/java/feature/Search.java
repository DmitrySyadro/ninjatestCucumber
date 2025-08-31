package feature;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Search {

    WebDriver driver;

    @Given("A user opens the Application")
    public void a_user_opens_the_application() {
        driver = DriverFactory.getDriver();
    }

    @When("A user enters the valid product {string} into Search box field")
    public void a_user_enters_the_valid_product_into_search_box_field(String product) {
        driver.findElement(By.name("search")).sendKeys(product);
    }

    @When("A user clicks on the Search button")
    public void a_user_clicks_on_the_search_button() {
        driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
    }

    @Then("The product should be displayed in the search results")
    public void the_product_should_be_displayed_in_the_search_results() {
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }

    @When("A user enters the invalid product {string} into the Search box field")
    public void a_user_enters_the_invalid_product_into_the_search_box_field(String invalidproduct) {
        driver.findElement(By.name("search")).sendKeys(invalidproduct);
    }

    @Then("A user should get a warning message about {string}")
    public void a_user_should_get_a_warning_message_about(String string) {
        Assert.assertEquals("Products meeting the search criteria",driver.findElement(By.xpath("//h2[contains(text(),'Products meeting the search criteria')]")).getText());
    }

    @When("A user doesn't enter any details into the Search box field")
    public void a_user_doesn_t_enter_any_details_into_the_search_box_field() {

    }


}
