package feature;

import com.beust.ah.A;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortBy {
    WebDriverWait wait;
    WebDriver driver;
    Select select;
    public SortBy() {
        this.driver = factory.DriverFactory.getDriver();
    }

    @Given("The user navigates to the {string} page")
    public void the_user_navigates_to_the_page(String string) {
        driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Components')]")).click();
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//li//a[contains(text(),'Monitors (2)')]")).click();

    }

    @Given("The user opens the {string} section")
    public void the_user_opens_the_section(String string)  {

            List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("//span[@class='price-new']"));
            List<Double> beforeFilterPriceList = new ArrayList<>();
            for(WebElement a:beforeFilterPrice){
                beforeFilterPriceList.add(Double.valueOf(a.getText().replace("$", "")));
            }
            WebElement dropDown = driver.findElement(By.xpath("//select[@id='input-sort']"));
            select = new Select(dropDown);
            select.selectByVisibleText("Price(Low > High)");
            List<WebElement> afterFilterPrice = driver.findElements(By.xpath("//span[@class='price-new']"));
            List<Double> afterFilterPriceList = new ArrayList<>();
            for(WebElement r: afterFilterPrice){
                afterFilterPriceList.add(Double.valueOf(r.getText().replace("$","")));
            }
            Collections.sort(beforeFilterPriceList);
            Collections.reverse(beforeFilterPriceList);
            Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }

    @When("The user selects {string} from the {string} dropdown")
    public void the_user_selects_from_the_dropdown(String string, String string2) {

    }

    @Then("The products should be sorted alphabetically by name in ascending order")
    public void the_products_should_be_sorted_alphabetically_by_name_in_ascending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted alphabetically by name in descending order")
    public void the_products_should_be_sorted_alphabetically_by_name_in_descending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The first product name should start with a letter closer to {string}")
    public void the_first_product_name_should_start_with_a_letter_closer_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The last product name should start with a letter closer to {string}")
    public void the_last_product_name_should_start_with_a_letter_closer_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted by price in ascending order")
    public void the_products_should_be_sorted_by_price_in_ascending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The first product should have the lowest price")
    public void the_first_product_should_have_the_lowest_price() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The last product should have the highest price")
    public void the_last_product_should_have_the_highest_price() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted by price in descending order")
    public void the_products_should_be_sorted_by_price_in_descending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The first product should have the highest price")
    public void the_first_product_should_have_the_highest_price() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The last product should have the lowest price")
    public void the_last_product_should_have_the_lowest_price() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted by rating in descending order")
    public void the_products_should_be_sorted_by_rating_in_descending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The first product should have the highest rating")
    public void the_first_product_should_have_the_highest_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The last product should have the lowest rating")
    public void the_last_product_should_have_the_lowest_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted by rating in ascending order")
    public void the_products_should_be_sorted_by_rating_in_ascending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The first product should have the lowest rating")
    public void the_first_product_should_have_the_lowest_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The last product should have the highest rating")
    public void the_last_product_should_have_the_highest_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted alphabetically by model in ascending order")
    public void the_products_should_be_sorted_alphabetically_by_model_in_ascending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The first product model should start with a letter closer to {string}")
    public void the_first_product_model_should_start_with_a_letter_closer_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The last product model should start with a letter closer to {string}")
    public void the_last_product_model_should_start_with_a_letter_closer_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The products should be sorted alphabetically by model in descending order")
    public void the_products_should_be_sorted_alphabetically_by_model_in_descending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
