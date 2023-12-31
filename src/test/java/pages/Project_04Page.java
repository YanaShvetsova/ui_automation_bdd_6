package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project_04Page {

    public Project_04Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Scenario 01 - Validate the default content of the inventory table
    @FindBy(css = ".is-size-2")
    public WebElement inventoryHeading;

    @FindBy(css = ".header")
    public List<WebElement>  inventoryTableHeader;

    @FindBy(id = "product_table")
    public WebElement table;

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "total_amount")
    public WebElement totalAmountText;

    //Scenario 02 - Validate the Add New Product modal

    @FindBy(id = "modal_title")
    public WebElement addProductHeader;

    @FindBy(css = ".modal-card")
    public WebElement addProductModal;

    @FindBy(css = ".delete")
    public WebElement xButton;

  //  @FindBy(id = "quantity")
   // public WebElement quantityInputBox;

    @FindBy(css = ".modal label")
    public List<WebElement> labels;

    @FindBy(css = ".input")
    public List<WebElement> productDetails;

   // @FindBy(id = "product")
   // public WebElement productInputBox;

   // @FindBy(id = "price")
   // public WebElement priceInputBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = "tbody tr:nth-child(4) td")
    public List<WebElement> addedRow;




















}
