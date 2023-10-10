package com.digital.pages;

import com.beust.ah.A;
import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DraggablePage extends BasePage {
    @FindBy(id = "dragBox")
    public WebElement dragMeBox;

    @FindBy(id = "draggableExample-tab-axisRestriction")
    public WebElement axisResctrictedTab;
    @FindBy(id = "draggableExample-tab-containerRestriction")
    public WebElement containerResctrictedTab;
    @FindBy(id = "draggableExample-tab-cursorStyle")
    public WebElement cursorTab;


    @FindBy(id = "restrictedX")
    public WebElement onlyXBox;

    @FindBy(id = "restrictedY")
    public WebElement onlyYBox;

    @FindBy(xpath = "//div[@id='containmentWrapper']/div")
    public WebElement containmentWrapper;


    @FindBy(xpath = "//span[contains(@class, 'ui-widget-header ui-draggable ui-draggable-handle')]")
    public WebElement containmentHeader;
    public DraggablePage moveDragMeBox(){

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(dragMeBox).moveByOffset(200,0).perform();
        elementActions.getAttributeByJS(dragMeBox,"style");
        actions.clickAndHold(dragMeBox).release().perform();
        Assert.assertTrue( elementActions.getAttributeByJS(dragMeBox,"style").contains("position: relative; left: 200px; top: 0px;"));
        return this;
    }

    public void switchToAxisRectrictedTab(){
        elementActions.clickElement(axisResctrictedTab);
    }
    public void switchToContainerRectrictedTab(){
        elementActions.clickElement(containerResctrictedTab);
    }
    public void switchToCursorTab(){
        elementActions.clickElement(cursorTab);
    }

    public DraggablePage checkOnlyXBox(){
        switchToAxisRectrictedTab();
        elementActions.moveElementWithOffset(onlyXBox,200,0);
        Assert.assertTrue( elementActions.getAttributeByJS(onlyXBox,"style").contains("position: relative; left: 200px; top: 0px;"));
        return this;
    }
    public DraggablePage checkOnlyYBox(){
        elementActions.moveElementWithOffset(onlyYBox,0,200);
        Assert.assertTrue( elementActions.getAttributeByJS(onlyYBox,"style").contains("position: relative; left: 0px; top: 200px;"));
        return this;
    }


    public DraggablePage checkContainmentWrapper(){
        switchToContainerRectrictedTab();
        elementActions.moveElementWithOffset(containmentWrapper,200,0);
        Assert.assertTrue( elementActions.getAttributeByJS(containmentWrapper,"style").contains("position: relative; left: 200px; top: 0px;"));
        Assert.assertTrue(containmentWrapper.getAttribute("innerText").contains("I'm contained within the box"));
        return this;
    }
    public DraggablePage checkContainmentHeader(){
        switchToContainerRectrictedTab();
        elementActions.moveElementWithOffset(containmentHeader,0,10);
        Assert.assertTrue( elementActions.getAttributeByJS(containmentHeader,"style").contains("position: relative; left: 0px; top: 10px;"));
        Assert.assertTrue(containmentHeader.getAttribute("innerText").contains("I'm contained within my parent"));
        return this;
    }

}
