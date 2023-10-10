package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
public class SortablePage extends BasePage {

    @FindBy(xpath = "//div[@id='demo-tabpane-list']/div/div")
    public List<WebElement> listOfItems;

    @FindBy(id = "demo-tab-grid")
    public WebElement gridBtn;


    @FindBy(xpath = "//div[@id='demo-tabpane-grid']/div/div/div")
    public List<WebElement> listOfItemsInGrid;

    @FindBy(xpath = "//div[@id='demo-tabpane-list']//div[contains(text(),'One')]")
    public WebElement firstElementInList;
    @FindBy(xpath = "//div[@id='demo-tabpane-grid']//div[contains(text(),'One')]")
    public WebElement firstElementInGrid;

    public SortablePage moveElementsInList() {
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDropBy(firstElementInList, 0, 50).perform();
        for (int i = 0; i < listOfItems.size(); i++) {
            if (i == 1) {
                Assert.assertTrue(listOfItems.get(i).getText().contains("One"));
            }
        }
        return this;
    }

    public SortablePage moveElementsInGrid() {
        elementActions.clickElement(gridBtn);
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDropBy(firstElementInGrid, 100, 0).perform();
        for (int i = 0; i < listOfItemsInGrid.size(); i++) {
            if (i == 1) {
                Assert.assertTrue(listOfItemsInGrid.get(i).getText().contains("One"));
            }
        }
        return this;
    }

}
