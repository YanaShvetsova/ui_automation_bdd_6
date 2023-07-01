package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project_04Page;
import pages.Project_05Page;
import utils.Driver;

public class BaseSteps {

    WebDriver driver;
    Project_04Page project_04Page;
    Project_05Page project_05Page;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        project_04Page = new Project_04Page();
        project_05Page = new Project_05Page();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @Then("user should see {string} in the url")
    public void userShouldSeeInTheUrl(String key) {
//        String newKey = driver.getCurrentUrl().replaceAll("_", " ");
//        Assert.assertTrue(newKey.contains(key));

        for(String word : key.split(" ")){
            Assert.assertTrue(driver.getCurrentUrl().contains(word));
        }
    }

    @And("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }
    @Then("the user should see the {string} heading")
    public void the_user_should_see_the_inventory_heading(String heading) {
        switch (heading){
            case "Inventory":
                Assert.assertTrue(project_04Page.inventoryHeading.isDisplayed());
                Assert.assertEquals(heading, project_04Page.inventoryHeading.getText());
                break;
            //Project_05
            case "Pagination":
                Assert.assertTrue(project_05Page.paginationHeading.isDisplayed());
                Assert.assertEquals(heading, project_05Page.paginationHeading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertTrue(project_05Page.worldCityPopulationsHeading.isDisplayed());
                Assert.assertEquals(heading, project_05Page.worldCityPopulationsHeading.getText());
                break;
            default:
        }

    }

    @Then("the user should see the {string} button is enabled")
    public void the_user_should_see_the_button_is_enabled(String button) {
        switch (button){
            case "ADD PRODUCT":
                Assert.assertTrue(project_04Page.addProductButton.isEnabled());
                break;
            case "X":
                Assert.assertTrue(project_04Page.xButton.isEnabled());
                break;
            case "SUBMIT":
                Assert.assertTrue(project_04Page.submitButton.isEnabled());
                break;
            //Project05
            case "Next":
                Assert.assertTrue(project_05Page.nextButton.isDisplayed());
                Assert.assertTrue(project_05Page.nextButton.isEnabled());
                break;
            case "Previous":
                Assert.assertTrue(project_05Page.previousButton.isDisplayed());
                Assert.assertTrue(project_05Page.previousButton.isEnabled());
                break;
            default:
        }
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        switch (button){
            case "ADD PRODUCT":
                project_04Page.addProductButton.click();
                break;
            case "X":
                project_04Page.xButton.click();
                break;
            case "SUBMIT":
                project_04Page.submitButton.click();
                break;
            //Project05
            case "Next":
                project_05Page.nextButton.click();
            default:
        }
    }
}
