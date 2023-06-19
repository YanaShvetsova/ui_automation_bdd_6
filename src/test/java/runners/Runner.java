package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@newProductAdded",
        dryRun = true,
        monochrome = false,
        plugin = {"pretty",
                "html:target/cucumber-reports/Cucumber.html",
                "json:target/cucumber-reports/Cucumber.json"}

)
public class Runner {
}
