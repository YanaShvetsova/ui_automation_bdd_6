package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WikiPage {


    public WikiPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBar;

    @FindBy(id = "firstHeading")
    public WebElement header;

    @FindBy(css = "a.link-box > strong")
    public List<WebElement> mainLanguages;
}
