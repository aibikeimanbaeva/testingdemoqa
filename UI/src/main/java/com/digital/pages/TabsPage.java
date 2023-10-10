package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TabsPage extends BasePage {
    @FindBy(id = "demo-tab-what")
    public WebElement whatTabs;

    @FindBy(xpath = "//div[@id='demo-tabpane-what']//p")
    public WebElement whatTabsText;


    @FindBy(id = "demo-tab-origin")
    public WebElement originTabs;

    @FindBy(xpath = "//div[@id='demo-tabpane-origin']//p")
    public WebElement originTabsText;
    @FindBy(id = "demo-tab-use")
    public WebElement useTabs;

    @FindBy(xpath = "//div[@id='demo-tabpane-use']//p")
    public WebElement useTabsText;
    @FindBy(id = "demo-tab-more")
    public WebElement moreTabs;


    public TabsPage clickToWhatTab() {
        elementActions.clickElement(whatTabs);
        Assert.assertTrue(whatTabsText.getText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,"));
        return this;
    }


    public TabsPage clickToOriginTab() {
        elementActions.clickElement(originTabs);
        Assert.assertTrue(originTabsText.getText().contains("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. "));

        return this;
    }

    public TabsPage clickToUseTab() {
        elementActions.clickElement(useTabs);
        Assert.assertTrue(useTabsText.getText().contains("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."));
        return this;
    }


    public TabsPage clicktoMoreTab() {
        Assert.assertTrue(moreTabs.isEnabled());
        return this;
    }


}
