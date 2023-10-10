package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends  BasePage{
    @FindBy(id = "frame1")
    public WebElement firstFrame;

    @FindBy(id="frame2")
    public WebElement secondFrame;
    public FramePage switchToFirstFrame(){
        framesHelper.switchToFrame(firstFrame).returnToDefaultContent();
        return  this;
    }
    public FramePage switchToSecondFrame(){
        framesHelper.switchToFrame(secondFrame).returnToDefaultContent();
        return  this;
    }


}
