package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project_05Page {

    public Project_05Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Scenario 01
    @FindBy(css = ".mb-5")
    public WebElement paginationHeading;

    @FindBy(id = "sub_heading")
    public WebElement worldCityPopulationsHeading;

    @FindBy(id = "content")
    public WebElement firstParagraph;

    //Scenario 02
    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = ".city_image")
    public WebElement cityImage;

    @FindBy(css = "p[class*='info']")
    public List<WebElement> cityInfo;


    public void clickNextButton(){
        while(nextButton.isEnabled()){
            nextButton.click();
        }
    }





}
