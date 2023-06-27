package steps;


import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project_05Page;
import utils.Driver;

public class Project_05Steps {

    WebDriver driver;
    Project_05Page project_05Page;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        project_05Page = new Project_05Page();
    }

    //Scenario: 01
    @Then("the user should see the {string} paragraph")
    public void the_user_should_see_the_paragraph(String paragraph) {
        Assert.assertTrue(project_05Page.firstParagraph.isDisplayed());
        Assert.assertEquals(paragraph, project_05Page.firstParagraph.getText());
    }

    //Scenario: 02
    @Then("the user should see the {string} button is disabled")
    public void the_user_should_see_the_button_is_disabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(project_05Page.previousButton.isDisplayed());
                Assert.assertFalse(project_05Page.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(project_05Page.nextButton.isDisplayed());
                Assert.assertFalse(project_05Page.nextButton.isEnabled());
                break;
            default:
        }
    }

    @When("the user clicks on the {string} button till it becomes disabled")
    public void the_user_clicks_on_the_button_till_it_becomes_disabled(String nextButton) {
        do {
            project_05Page.nextButton.click();
        } while (project_05Page.nextButton.isEnabled());
        Assert.assertFalse(project_05Page.nextButton.isEnabled());

    }

    //Scenario 03
    @Then("the user should see City as {string}, Country as {string} and Population {string}  with the info below and an image")
    public void the_user_should_see_city_as_country_as_and_population_with_the_info_below_and_an_image(String city, String country, String population) {
        Assert.assertEquals(city, project_05Page.cityInfo.getText());
        Assert.assertEquals(country, project_05Page.countryInfo.getText());
        Assert.assertEquals(population, project_05Page.populationInfo.getText());

    }
}
