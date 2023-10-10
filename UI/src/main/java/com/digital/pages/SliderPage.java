package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class SliderPage extends BasePage{

    @FindBy(xpath = "//div[@id='sliderContainer']//input[1]")
    public WebElement rangeInput;

    @FindBy(id = "sliderValue")
    public WebElement sliderValueInput;


    public SliderPage chooseRange() {
        rangeInput.clear();
        int maxValue = 100;
        double percentage = (double) 20 / (double) maxValue;
        int sliderWidth = rangeInput.getSize().getWidth();
        int xOffset = (int) (sliderWidth * percentage);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(rangeInput, xOffset, 0).clickAndHold().release().build().perform();
        return this;
    }

    public SliderPage test(){
        Assert.assertEquals(rangeInput.getAttribute("value"), "70");
        Assert.assertEquals(sliderValueInput.getAttribute("value"), "70");
        return this;
    }

}
