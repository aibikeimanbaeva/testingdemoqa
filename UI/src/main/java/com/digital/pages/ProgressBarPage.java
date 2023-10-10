package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
public class ProgressBarPage extends BasePage{

    @FindBy (id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(xpath = "//div[@role='progressbar']")
    public  WebElement progressBar;


    public ProgressBarPage clickToStartBtn(){
        elementActions.clickElement(startStopButton);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100%"));
        String finalPercentage = progressBar.getAttribute("innerText");
        Assert.assertEquals(finalPercentage, "100%");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


}
