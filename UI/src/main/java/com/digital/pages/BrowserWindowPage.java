package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowPage extends BasePage {

    @FindBy(id = "tabButton")
    public WebElement tabBtn;

    @FindBy(tagName = "h1")
    public WebElement textFromNewTab;

    @FindBy(id = "windowButton")
    public WebElement windowBtn;

    @FindBy(tagName = "h1")
    public WebElement textFromNewWindow;

    @FindBy(id = "messageWindowButton")
    public WebElement messageWindowBtn;

    @FindBy(tagName = "h1")
    public WebElement messageWindowText;
    public BrowserWindowPage clickTabBtn() {
        elementActions.clickElement(tabBtn);
        ArrayList<String> tabs = elementActions.getAllWindowsHandles();
        elementActions.switchToTargetWindow(tabs, 1);
        Assert.assertEquals(textFromNewTab.getText(), "This is a sample page");
        Driver.getDriver().close();
        elementActions.switchToTargetWindow(tabs, 0);
        return this;
    }

    public BrowserWindowPage clickWindowBtn(){
        elementActions.clickElement(windowBtn);
        ArrayList<String> tabs = elementActions.getAllWindowsHandles();
        elementActions.switchToTargetWindow(tabs, 1);
        Assert.assertEquals(textFromNewWindow.getText(), "This is a sample page");
        Driver.getDriver().close();
        elementActions.switchToTargetWindow(tabs, 0);
        return this;
    }

    public BrowserWindowPage clickMessageWindowBtn(){
        elementActions.clickElement(windowBtn);
        ArrayList<String> tabs = elementActions.getAllWindowsHandles();
        elementActions.switchToTargetWindow(tabs, 1);
        Assert.assertEquals(messageWindowText.getText(), "This is a sample page");
        Driver.getDriver().close();
        elementActions.switchToTargetWindow(tabs, 0);
        return this;
    }


}
