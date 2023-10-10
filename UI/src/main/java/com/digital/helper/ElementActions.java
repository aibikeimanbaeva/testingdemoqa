package com.digital.helper;

import com.digital.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ElementActions {
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    Actions actions;

    public ElementActions waitElementToBeClickable(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            return this;
        }
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }


    public ElementActions waitElementToBeVisible(WebElement element) {
        if (element.isDisplayed()) {
            return this;
        }
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public ElementActions clickElement(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public ElementActions writeText(WebElement element, String txt) {
        waitElementToBeVisible(element);
        element.sendKeys(txt);
        return this;
    }

    public ElementActions hideElementByJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.display='none'", element);
        return this;
    }

    public ElementActions scrollByPixels(int px) {
        String script = "window.scrollBy(0, " + px + ");";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);
        return this;
    }


    public ElementActions scrollToTheElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", element);
        return this;
    }

    public ElementActions clickByJS(WebElement element) {
        waitElementToBeVisible(element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public boolean checkHoverEffect(WebElement element, String cssProperty) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String hoverValue = element.getCssValue(cssProperty);
        return hoverValue != null && !hoverValue.isEmpty();
    }

    public boolean checkStyleChangeOnHover(WebElement element, String cssProperty) {
        String originalValue = element.getCssValue(cssProperty);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String hoverValue = element.getCssValue(cssProperty);
        return !originalValue.equals(hoverValue);
    }



    public ElementActions clickToRandomElement(List<WebElement> element) {
        int randomIndex = new Random().nextInt(element.size());
        WebElement randomLabel = element.get(randomIndex);
        clickElement(randomLabel);
        return this;
    }


    public void setAttributeValueByJS(WebElement element, String attributeName, String attributeValue) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    public String getAttributeByJS(WebElement element, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        return (String) js.executeScript("return arguments[0].getAttribute(arguments[1]);", element, attributeName);
    }


    public boolean checkActiveStyle(WebElement element, String cssProperty, String targetClass) {
        String classes = element.getAttribute("class");
        return classes != null && classes.contains(targetClass) && element.getCssValue(cssProperty) != null;
    }


    public ElementActions moveElementWithOffset(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(element).moveByOffset(xOffset, yOffset).release().perform();
        return this;
    }

    public ElementActions moveToElement(WebElement element) {
        actions= new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();
        return this;
    }


    public WebElement getSelectedOptionInSelect(WebElement element){
        waitElementToBeVisible(element);
        Select select = new Select(element);
        WebElement selectedElem = select.getFirstSelectedOption();
        return  selectedElem;
    }

    public ElementActions selectRandomInSelect(WebElement selectList) {
        waitElementToBeVisible(selectList);
        Select select = new Select(selectList);
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size());
        select.selectByIndex(randomIndex);
        return this;
    }





    public ElementActions setTextAndEnterElement(WebElement element, String txt) {
        writeText(element, txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public ElementActions doubleClick(WebElement element) {
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(element);
        return this;
    }

    public ElementActions rightClick(WebElement element) {
        actions = new Actions(Driver.getDriver());
        actions.contextClick(element);
        return this;
    }

    public ArrayList<String> getAllWindowsHandles() {
        ArrayList<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        return tabs;
    }

    public ElementActions switchToTargetWindow(ArrayList<String> tabs, int index) {
        Driver.getDriver().switchTo().window(tabs.get(index));
        return this;
    }

    public void switchToNewTab() {
        LinkedList<String> tabs = new LinkedList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void switchToPreviousTab(int windowsNum) {
        LinkedList<String> tabs = new LinkedList<>(Driver.getDriver().getWindowHandles());
        if (tabs.size() > 1) {
            Driver.getDriver().switchTo().window(tabs.get(tabs.size() - windowsNum));
        }
    }

    public ElementActions navigateBack() {
        Driver.getDriver().navigate().back();
        return this;
    }


}
