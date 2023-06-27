package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

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

    //Scenario 03
    //@FindBy(css = "Pagination_pagBodyData__up2c0")
    //public WebElement cityInfo;

    @FindBy(css = ".city_info")
    public WebElement cityInfo;

    @FindBy(css = ".country_info")
    public WebElement countryInfo;

    @FindBy(css = ".population_info")
    public WebElement populationInfo;







}
