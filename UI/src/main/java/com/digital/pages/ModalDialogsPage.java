package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ModalDialogsPage extends BasePage{

    @FindBy(id = "showSmallModal")
    public WebElement smallModalBtn;

    @FindBy(id = "closeSmallModal")
    public WebElement closeSmallModalBtn;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalBtn;


    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement smallModalText;

    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModalBtn;

    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement largeModalText;

    public ModalDialogsPage openSmallModal(){
        elementActions.clickElement(smallModalBtn);
        Assert.assertEquals(smallModalText.getText(),"This is a small modal. It has very less content");
        elementActions.clickElement(closeSmallModalBtn);
        return this;
    }

    public ModalDialogsPage openLargeModal(){
        elementActions.clickElement(largeModalBtn);
        Assert.assertTrue(largeModalText.getText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        elementActions.clickElement(closeLargeModalBtn);
        return this;
    }
}
