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

import utils.Driver;
import utils.TableHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project_04Steps {
    WebDriver driver;
    Project_04Page project_04Page;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        project_04Page = new Project_04Page();
    }

    //Scenario: 01 - Validate the default content of the inventory table

    @Then("the user should see the {string} heading")
    public void the_user_should_see_the_inventory_heading(String inventoryHeading) {
        Assert.assertTrue(project_04Page.inventoryHeading.isDisplayed());
        Assert.assertEquals(project_04Page.inventoryHeading.getText(), "Inventory");

    }

    @And("the user should see the table with the headers below")
    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();
        for (int i = 0; i <= expectedText.size()-1; i++) {
            Assert.assertTrue(project_04Page.inventoryTableHeader.get(i).isDisplayed());
            Assert.assertEquals(project_04Page.inventoryTableHeader.get(i).getText(), expectedText.get(i));
        }

    }

    @And("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
        List<List<WebElement>> inventoryTableData = TableHandler.getTableData(project_04Page.inventoryTable);

        List<List<String>> expectedTableText = dataTable.asLists();
        expectedTableText.add(Arrays.asList("1", "iPhone", "1,000", "1,000"));
        expectedTableText.add(Arrays.asList("3", "Airpods", "100", "300 "));
        expectedTableText.add(Arrays.asList("2", "iPad ", "500 ", "1,000"));

        Assert.assertEquals(inventoryTableData.get(2).get(1).getText(), inventoryTableData.get(2).get(1));

        for (int i = 0; i < inventoryTableData.size(); i++) {
            for (int j = 0; j < inventoryTableData.get(i).size(); j++) {
                Assert.assertEquals(inventoryTableData.get(i).get(j).getText(), inventoryTableData.get(i).get(j));
            }
        }
    }

    @And("the user should see the {string} button is enabled")
    public void the_user_should_see_the_add_product_button_is_enabled(String addProductButton) {
        Assert.assertTrue(project_04Page.addProductButton.isDisplayed());
        Assert.assertTrue(project_04Page.addProductButton.isEnabled());
        Assert.assertEquals(project_04Page.addProductButton.getText(), "ADD PRODUCT");

    }

    @And("the user should see the {string} text displayed")
    public void the_user_should_see_the_total_$_text_displayed(String totalAmountText) {
        Assert.assertTrue(project_04Page.totalAmountText.isDisplayed());
        Assert.assertTrue(project_04Page.totalAmountText.isEnabled());
        Assert.assertEquals(project_04Page.totalAmountText.getText(), "Total = $2,300");

    }

    //Scenario: 02 - Validate the Add New Product modal
    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String addProductButton) {
        project_04Page.addProductButton.click();
    }

    @Then("the user should see the {string} modal with its heading")
    public void the_user_should_see_the_modal_with_its_heading(String addProductHeader) {
        Assert.assertTrue(project_04Page.addProductHeader.isDisplayed());
        Assert.assertEquals(addProductHeader, project_04Page.addProductHeader.getText());

    }

    //step for x button?

    @And("the user should see the {string} label")
    public void the_user_should_see_the_label(String productQuantityLabel) {
        Assert.assertTrue(project_04Page.productQuantityLabel.isDisplayed());
        Assert.assertEquals(productQuantityLabel, project_04Page.productQuantityLabel.getText());
    }

    @And("the user should see the {string} input box is enabled")
    public void the_user_should_see_the_input_box_is_enabled(String quantityInputBox) {
        Assert.assertTrue(project_04Page.quantityInputBox.isDisplayed());
        Assert.assertTrue(project_04Page.quantityInputBox.isEnabled());
    }

    //Scenario: 03 - Validate the Add New Product modal X button
    @When("the user clicks on the X button")
    public void the_user_clicks_on_the_x_button(String xButton) {
        project_04Page.xButton.click();
    }

    @Then("the user should not see the {string} modal")
    public void the_user_should_not_see_the_modal(String addProductModal) {
        Assert.assertFalse(project_04Page.addProductModal.isDisplayed());
    }

    //Scenario: 04 - Validate the new product added
    @When("the user enters the quantity as {string}")
    public void the_user_enters_the_quantity_as(String quantityInputBox) {
        project_04Page.quantityInputBox.sendKeys("2");
    }
    @And("the user enters the product as {string}")
    public void the_user_enters_the_product_as(String productInputBox) {
        project_04Page.productInputBox.sendKeys("Mouse");
    }
    @And("the user enters the price as {string}")
    public void the_user_enters_the_price_as(String priceInputBox) {
        project_04Page.priceInputBox.sendKeys("100");
    }
    @Then("the user should see the table with the new row below")
    public void the_user_should_see_the_table_with_the_new_row_below(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();
        for (int i = 0; i <= expectedText.size()-1; i++) {
            Assert.assertTrue(project_04Page.addedRow.get(i).isDisplayed());
            Assert.assertEquals(project_04Page.addedRow.get(i).getText(), expectedText.get(i));
        }
    }




}
