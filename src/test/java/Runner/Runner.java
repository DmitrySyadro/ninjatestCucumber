package Runner;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features",
        glue = {"feature","hooks"},
        plugin= {
                "pretty",
                "html:target/Cucumber/CucumberReport.html",
                "json:target/Cucumber/cucumber.json",
                "junit:target/Cucumber/CucumberReport.xml"

        },
        publish = true,
        monochrome = true

)


public class Runner{

}
