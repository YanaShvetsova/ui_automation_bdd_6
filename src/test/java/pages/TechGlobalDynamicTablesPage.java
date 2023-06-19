package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TechGlobalDynamicTablesPage {

    public TechGlobalDynamicTablesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "modal_title")
    public WebElement modalCardTitle;

    @FindBy(css = ".delete")
    public WebElement closeButton;

    @FindBy(id = "main_heading")
    public WebElement headingText;
}
