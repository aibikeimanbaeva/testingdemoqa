package com.digital.pages;

import com.beust.ah.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RadioButtonPage extends BasePage {
    @FindBy(xpath = "//label[@class='custom-control-label'][1]")
    public WebElement clickYesBtn;

    @FindBy(xpath = "(//label[@class='custom-control-label'])[2]")
    public WebElement clickImpessiveBtn;

    @FindBy(xpath = "//label[@class='custom-control-label disabled']")
    public WebElement clickNoBtn;

    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement resultBtnYes;

    @FindBy(xpath = "(//label[@class='custom-control-label'])[2]")
    public WebElement resultImpessiveBtn;

    public RadioButtonPage clickYesBtn() {
        elementActions.clickElement(clickYesBtn);
        Assert.assertTrue(resultBtnYes.getText().contains("Yes"));
        return this;
    }

    public RadioButtonPage clickImpessiveBtn() {
        elementActions.clickElement(clickImpessiveBtn);
        Assert.assertTrue(resultImpessiveBtn.getText().contains("Impressive"));
        return this;
    }

    public RadioButtonPage clickNoBtn() {
        elementActions.clickElement(clickNoBtn);
        Assert.assertTrue(clickNoBtn.isEnabled());
        return this;
    }



}
