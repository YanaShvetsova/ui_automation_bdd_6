package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WikiPage;
import utils.Driver;

import java.util.List;

public class WikiSteps {

    /*
    Given user navigates to "http://www.wikipedia.org/"
    When user searches for "Elon Musk" on Wikipedia
    Then user should see "Elon Musk" in the title
    And user should see "Elon Musk" in the url
    And user should see "Elon Musk" in the first heading
     */
    WebDriver driver;
    WikiPage wikiPage;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        wikiPage = new WikiPage();
    }

    @When("user searches for {string} on Wikipedia")
    public void userSearchesForOnWikipedia(String input) {
        wikiPage.searchBar.sendKeys(input + Keys.ENTER);

    }

    @And("user should see {string} in the first heading")
    public void userShouldSeeInTheFirstHeading(String header) {
        Assert.assertTrue(wikiPage.header.isDisplayed());
        Assert.assertEquals(header, wikiPage.header.getText());
    }

    @Then("user should see below languages around the logo")
    public void user_should_see_below_languages_around_the_logo(DataTable dataTable) {

        List<String> expectedText = dataTable.asList();

        for (int i = 0; i < expectedText.size(); i++) {
            Assert.assertEquals(expectedText.get(i), wikiPage.mainLanguages.get(i).getText());
        }
    }
}
