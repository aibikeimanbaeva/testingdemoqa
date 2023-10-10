package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SelectablePage extends BasePage{

    @FindBy(xpath = "//ul[@id='verticalListContainer']/li[contains(@class, 'list-group-item')]")
    public List<WebElement> listOfVerticalDiv;

    @FindBy(xpath = "//div[@id='gridContainer']//li")
    public List<WebElement> listOfGridDiv;

    @FindBy(id = "demo-tab-grid")
    public WebElement gridBtn;

    public SelectablePage checkItemInVerticalDiv(){
        for (WebElement element:listOfVerticalDiv){
            elementActions.clickElement(element);
            boolean  hasActive = elementActions.checkActiveStyle(element,"background-color","active");
            Assert.assertTrue(hasActive);
        }
        return this;
    }

    public SelectablePage checkItemInGridDiv(){
        elementActions.clickElement(gridBtn);
        for (WebElement element:listOfGridDiv){
            elementActions.clickElement(element);
            boolean  hasActive = elementActions.checkActiveStyle(element,"background-color","active");
            Assert.assertTrue(hasActive);
        }
        return this;
    }









}
