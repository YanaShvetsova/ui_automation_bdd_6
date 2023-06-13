package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import utils.Driver;

public class GoogleSteps {
    WebDriver driver;
    GoogleSearchPage googleSearchPage;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        googleSearchPage = new GoogleSearchPage();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @When("user search for {string}")
    public void userSearchFor(String key) {
        googleSearchPage.searchInputBox.sendKeys(key + Keys.ENTER);
    }

    @Then("user should see {string} in the url")
    public void userShouldSeeInTheUrl(String key) {
        Assert.assertTrue(driver.getCurrentUrl().contains(key));
    }

    @And("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }
}
