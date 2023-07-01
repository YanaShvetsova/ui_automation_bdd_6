package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project_05Page;
import utils.Driver;

import java.util.List;

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
        project_05Page.clickNextButton();

    }

    //Scenario 03
    @Then("the user should see {string} City with the info below and an image")
    public void the_user_should_see_city_with_the_info_below_and_an_image(String string, DataTable dataTable) {
        List<String> expectedText = dataTable.asList();

        for (int i = 0; i < expectedText.size(); i++) {
            Assert.assertTrue(project_05Page.cityImage.isDisplayed());
            Assert.assertEquals(expectedText.get(i), project_05Page.cityInfo.get(i).getText());
        }

    }
}
