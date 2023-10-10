package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ButtonPage extends BasePage {
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;
    @FindBy(id="rightClickBtn")
    public WebElement rightClickBtn;
    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement simpleCLickBtn;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    public ButtonPage makeDoubleClick(){
        elementActions.doubleClick(doubleClickBtn);
        return this;
    }
    public ButtonPage makeRightClick(){
        elementActions.rightClick(rightClickBtn);
        return this;
    }
    public ButtonPage makeSimpleClick(){
        elementActions.clickElement(simpleCLickBtn);
        return this;
    }

    public ButtonPage testButtons(){
        Assert.assertEquals(doubleClickBtn.getAttribute("innerText"), "Double Click Me");
        Assert.assertEquals(rightClickBtn.getAttribute("innerText"), "Right Click Me");
        Assert.assertEquals(dynamicClickMessage.getAttribute("innerText"), "You have done a dynamic click");
        return this;
    }

}
