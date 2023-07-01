package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Project_04Page;

import pages.Project_05Page;
import utils.Driver;
import utils.TableHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Project_04Steps {
    WebDriver driver;
    Project_04Page project_04Page;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        project_04Page = new Project_04Page();
    }

    @And("the user should see the table with the headers below")
    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();

        for (int i = 0; i <= expectedText.size()-1; i++) {
            Assert.assertTrue(project_04Page.inventoryTableHeader.get(i).isDisplayed());
            Assert.assertEquals(expectedText.get(i), project_04Page.inventoryTableHeader.get(i).getText());
        }

    }

    @Then("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists();
        List<List<WebElement>> actualTable = TableHandler.getTableData(project_04Page.table);

        for (int i = 0; i < expectedTable.size(); i++) {
            for (int j = 0; j < expectedTable.get(i).size(); j++) {
                Assert.assertEquals(expectedTable.get(i).get(j), actualTable.get(i).get(j).getText());
            }
        }

    }



    @And("the user should see the {string} text displayed")
    public void the_user_should_see_the_total_$_text_displayed(String totalAmountText) {
        Assert.assertTrue(project_04Page.totalAmountText.isDisplayed());
        Assert.assertTrue(project_04Page.totalAmountText.isEnabled());
        Assert.assertEquals(totalAmountText, project_04Page.totalAmountText.getText());

    }

    @Then("the user should see the {string} modal with its heading")
    public void the_user_should_see_the_modal_with_its_heading(String addProductHeader) {
        Assert.assertTrue(project_04Page.addProductHeader.isDisplayed());
        Assert.assertEquals(addProductHeader, project_04Page.addProductHeader.getText());

    }


    @And("the user should see the {string} label")
    public void theUserShouldSeeTheLabel(String label) {
        switch (label){
            case "Please select the quantity":
                Assert.assertTrue(project_04Page.labels.get(0).isDisplayed());
                break;
            case "Please enter the name of the product":
                Assert.assertTrue(project_04Page.labels.get(1).isDisplayed());
                break;
            case "Please enter the price of the product":
                Assert.assertTrue(project_04Page.labels.get(2).isDisplayed());
                break;
            default:
        }
    }

    @And("the user should see the {string} input box is enabled")
    public void theUserShouldSeeTheInputBoxIsEnabled(String inputBox) {
        switch (inputBox) {
            case "Quantity":
                Assert.assertTrue(project_04Page.productDetails.get(0).isEnabled());
                break;
            case "Product":
                Assert.assertTrue(project_04Page.productDetails.get(1).isEnabled());
                break;
            case "Price":
                Assert.assertTrue(project_04Page.productDetails.get(2).isEnabled());
                break;
            default:
        }
    }

    //Scenario: 03 - Validate the Add New Product modal X button
    @When("the user clicks on the X button")
    public void the_user_clicks_on_the_x_button(String xButton) {
        project_04Page.xButton.click();
    }

    @Then("the user should not see the Add New Product modal")
    public void theUserShouldNotSeeTheModal() {
        try {
            Assert.assertFalse(project_04Page.addProductHeader.isDisplayed());
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    //Scenario: 04 - Validate the new product added
    @And("the user enters the {string} as {string}")
    public void theUserEntersTheAs(String details, String input) {
        switch (details){
            case "Quantity":
                project_04Page.productDetails.get(0).sendKeys(input);
                break;
            case "Product":
                project_04Page.productDetails.get(1).sendKeys(input);
                break;
            case"Price":
                project_04Page.productDetails.get(2).sendKeys(input);
                break;
            default:
        }

    }

    @Then("the user should see the table with the new row below")
    public void theUserShouldSeeTheTableWithTheNewRowBelow(DataTable dataTable) {
        List<String> expectedRow = dataTable.asList();

        for (int i = 0; i < expectedRow.size(); i++) {
            Assert.assertEquals(expectedRow.get(i), TableHandler.getTableRow(4).get(i).getText());
        }
    }





}
