package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResizblePage extends BasePage{
    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']//span")
    public WebElement actionBtnOfFirstDiv;

    @FindBy(id = "resizableBoxWithRestriction")
    public WebElement firstTargetDiv;
    @FindBy(id = "resizable")
    public WebElement secondTargetDiv;
    @FindBy(xpath = "//div[@id='resizable']//span")
    public WebElement actionBtnOfSecondDiv;

    public ResizblePage checkFirstResizbleDiv(){
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(actionBtnOfFirstDiv).moveByOffset(300,0).release().perform();
        String widthOfDiv = elementActions.getAttributeByJS(firstTargetDiv,"style");
        Assert.assertEquals(widthOfDiv, "width: 500px; height: 200px;");
        return this;
    }

    public ResizblePage checkSecondResizbleDiv(){
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(actionBtnOfSecondDiv).moveByOffset(300,0).release().perform();
        String widthOfDiv = elementActions.getAttributeByJS(secondTargetDiv,"style");
        Assert.assertEquals(widthOfDiv, "width: 500px; height: 200px;");
        return this;
    }
}
