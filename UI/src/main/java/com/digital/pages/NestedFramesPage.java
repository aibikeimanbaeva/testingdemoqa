package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NestedFramesPage extends BasePage{

    @FindBy(id = "frame1")
    public WebElement parentFrame;

    @FindBy (tagName = "body")
    public WebElement parentText;

    @FindBy (tagName = "p")
    public WebElement childText;
    public NestedFramesPage swithToParentFrame(){
       framesHelper.switchToFrame(parentFrame);
        Assert.assertEquals(parentText.getText(),"Parent frame");
        switchToChildFrame();
        return this;
    }

    public NestedFramesPage switchToChildFrame(){
        framesHelper.switchByIndex(0);
        Assert.assertEquals(childText.getText(),"Child Iframe");
        return this;
    }

}
