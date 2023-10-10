package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "withOptGroup")
    public WebElement selectOptionInput;

    @FindBy (xpath = "//div[@id='withOptGroup']//div[contains(text(), 'option')]")
    public List<WebElement> menuSelectOption;


    @FindBy (xpath = "//div[@class=' css-1uccc91-singleValue']")
    public WebElement inputValueInSelectOption;


    @FindBy(id = "selectOne")
    public WebElement selectOneInput;

    @FindBy (xpath = "//div[@id='selectOne']/div[2]/div")
    public List<WebElement> menuSelectOne;

    @FindBy (xpath = "//div[@class=' css-1wa3eu0-placeholder']")
    public WebElement inputValueInSelectOne;

    @FindBy (id = "oldSelectMenu")
    public WebElement select;


    @FindBy (xpath = "(//div[@class=' css-2b097c-container'])[3]")
    public WebElement multiSelect;


    @FindBy (xpath = "(//div[@class=' css-2b097c-container'])[3]/div[2]/div")
    public List<WebElement> menuInMultiSelect;

    @FindBy (xpath = "(//div[@class=' css-1hwfws3'])[3]")
    public WebElement inputValueInMultiSelect;


    @FindBy (id = "cars")
    public WebElement selectCar;
    public SelectMenuPage checkSelectOption(){
        elementActions.clickElement(selectOptionInput);
        elementActions.clickToRandomElement(menuSelectOption);
        Assert.assertTrue(inputValueInSelectOption.getAttribute("innerText").contains("option"));
        return this;
    }


    public SelectMenuPage checkSelectOne(){
        elementActions.clickElement(selectOneInput);
        elementActions.clickToRandomElement(menuSelectOne);
        Assert.assertNotNull(inputValueInSelectOne.getAttribute("innerText"));
        return this;
    }

    public SelectMenuPage checkSelect(){
        elementActions.selectRandomInSelect(select);
        WebElement selectedElem = elementActions.getSelectedOptionInSelect(select);
        Assert.assertNotNull(selectedElem);
        return this;
    }

    public SelectMenuPage checkMultiSelect(){
        elementActions.clickElement(multiSelect);
        elementActions.clickToRandomElement(menuInMultiSelect);
        elementActions.clickToRandomElement(menuInMultiSelect);
        elementActions.clickElement(multiSelect);
        Assert.assertNotNull(inputValueInMultiSelect.getAttribute("innerText"));
        return this;
    }


    public SelectMenuPage checkSelectCar(){
        elementActions.selectRandomInSelect(selectCar);
        WebElement element = elementActions.getSelectedOptionInSelect(selectCar);
        Assert.assertNotNull(element);
        return this;
    }

}
