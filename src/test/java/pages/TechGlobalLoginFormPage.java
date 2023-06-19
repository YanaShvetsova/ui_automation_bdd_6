package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TechGlobalLoginFormPage {

    public TechGlobalLoginFormPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "error_message")
    public WebElement error;

    @FindBy(id = "main_heading")
    public WebElement headingText;

    @FindBy(id = "success_lgn")
    public WebElement successLogin;

}
