package com.digital.pages;

import com.beust.ah.A;
import com.digital.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {

    @FindBy(id = "draggable")
    public WebElement draggableBlock;

    @FindBy(xpath = "//div[@id='droppable']/p")
    public WebElement droppableBlockText;
    @FindBy(xpath = "//div[@id='droppable']")
    public WebElement droppableBlock;

    @FindBy(id = "droppableExample-tab-accept")
    public WebElement acceptBtn;

    @FindBy(id = "droppable")
    public WebElement acceptableBlock;

    @FindBy(id = "notAcceptable")
    public WebElement notAcceptableBtn;


    @FindBy(id = "acceptable")
    public WebElement acceptableBtnToCLickAndDrop;


    @FindBy(id = "droppableExample-tab-preventPropogation")
    public WebElement preventPropoginationTab;

    @FindBy(id = "dragBox")
    public WebElement dragMeBtnInPreventTab;

    @FindBy(id = "notGreedyDropBox")
    public WebElement notGreedyDropBox;


    @FindBy(id = "greedyDropBoxInner")
    public WebElement greedyDropBoxInner;

    @FindBy(id = "notGreedyInnerDropBox")
    public WebElement notGreedyInnerDropBox;

    @FindBy(id = "droppableExample-tab-revertable")
    public WebElement revertTab;

    @FindBy(id = "revertable")
    public WebElement revertableBtn;

    @FindBy(id = "notRevertable")
    public WebElement notRevertableBtn;

    @FindBy(xpath = "//div[@id='revertableDropContainer']//div[@id='droppable']")
    public WebElement droppableBlockInRevertTab;

    public DroppablePage moveDraggableBlock() {
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(draggableBlock).moveByOffset(300, 0).release().perform();
        return this;
    }

    public DroppablePage checkDroppableBlock() {
        Assert.assertTrue(droppableBlockText.getAttribute("innerText").contains("Dropped"));
        return this;
    }

    public DroppablePage checkDroppableColor() {
        boolean hasNewClass = elementActions.checkActiveStyle(droppableBlock, "background-color", "ui-droppable");
        Assert.assertTrue(hasNewClass);
        return this;
    }

    public void switchToAcceptTab() {
        elementActions.clickElement(acceptBtn);
    }


    public DroppablePage checkAcceptableBlockColor() {
        switchToAcceptTab();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(acceptableBtnToCLickAndDrop).moveByOffset(20, 0).perform();
        boolean hasNewClass = elementActions.checkActiveStyle(acceptableBlock, "background-color", "ui-droppable-active");
        Assert.assertTrue(hasNewClass);
        actions.clickAndHold(acceptableBtnToCLickAndDrop).moveByOffset(300, 0).release().perform();
        Assert.assertTrue(acceptableBlock.getAttribute("innerText").contains("Dropped"));
        actions.clickAndHold(notAcceptableBtn).moveByOffset(350, 0).release().perform();
        return this;
    }


    public void swithToPreventPropoginationTab() {
        elementActions.clickElement(preventPropoginationTab);
    }

    public DroppablePage checkOuterDroppableBlock() {
        swithToPreventPropoginationTab();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(dragMeBtnInPreventTab).moveByOffset(10, 0).perform();
        boolean hasNewClass = elementActions.checkActiveStyle(notGreedyDropBox, "background-color", "ui-droppable-active");
        Assert.assertTrue(hasNewClass);
        boolean hasNewClassInGreedyBox = elementActions.checkActiveStyle(greedyDropBoxInner, "background-color", "ui-droppable-active");
        Assert.assertTrue(hasNewClassInGreedyBox);
        actions.clickAndHold(dragMeBtnInPreventTab).release().perform();
        return this;
    }


    public DroppablePage checkHoverInOuterDroppableBlock() {
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(dragMeBtnInPreventTab).moveByOffset(300, 0).perform();
        boolean hasNewClass = elementActions.checkActiveStyle(notGreedyDropBox, "background-color", "ui-hover");
        Assert.assertTrue(hasNewClass);
        actions.clickAndHold(dragMeBtnInPreventTab).release().perform();
        Assert.assertTrue(notGreedyDropBox.getAttribute("innerText").contains("Dropped"));
        return this;
    }

    public DroppablePage checkHoverInInnerDroppableBlock() {
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(dragMeBtnInPreventTab).moveByOffset(0, 70).perform();
        boolean hasNewClass = elementActions.checkActiveStyle(notGreedyInnerDropBox, "background-color", "ui-hover");
        Assert.assertTrue(hasNewClass);
        actions.clickAndHold(dragMeBtnInPreventTab).release().perform();
        Assert.assertTrue(notGreedyInnerDropBox.getAttribute("innerText").contains("Dropped"));
        return this;
    }

    public void switchToRevertDraggable() {
        elementActions.clickElement(revertTab);
    }


    public DroppablePage checkRevertableBtn() {
        switchToRevertDraggable();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(revertableBtn).moveByOffset(50, 0).perform();
        boolean hasNewClass = elementActions.checkActiveStyle(droppableBlockInRevertTab, "background-color", "ui-active");
        Assert.assertTrue(hasNewClass);
        actions.clickAndHold(revertableBtn).moveByOffset(250, 0).release().perform();
        Assert.assertTrue(droppableBlockInRevertTab.getAttribute("innerText").contains("Dropped"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String styleOfRevertableBtn = elementActions.getAttributeByJS(revertableBtn, "style");
        System.out.println(styleOfRevertableBtn);
        Assert.assertTrue(styleOfRevertableBtn.contains("position: relative; left: 0px; top: 0px;"));

        return this;
    }

    public DroppablePage checkNotRevertableBtn() {
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(notRevertableBtn).moveByOffset(50, 0).perform();
        boolean hasNewClass = elementActions.checkActiveStyle(droppableBlockInRevertTab, "background-color", "ui-active");
        Assert.assertTrue(hasNewClass);
        actions.clickAndHold(notRevertableBtn).moveByOffset(250, 0).release().perform();
        Assert.assertTrue(droppableBlockInRevertTab.getAttribute("innerText").contains("Dropped"));
        String styleOfNotRevertableBtn = elementActions.getAttributeByJS(notRevertableBtn, "style");
        Assert.assertFalse(styleOfNotRevertableBtn.contains("position: relative; left: 0px; top: 0px;"));
        return this;
    }


}
