package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccordianPage extends BasePage{

    @FindBy(id = "section1Heading")
    public WebElement firstAccordianBtn;

    @FindBy (id = "section1Content")
    public WebElement firstAccordianText;

    @FindBy(id = "section2Heading")
    public WebElement secAccordianBtn;

    @FindBy (id = "section2Content")
    public WebElement secAccordianText;



    @FindBy(id = "section3Heading")
    public WebElement thirdAccordianBtn;

    @FindBy (id = "section3Content")
    public WebElement thirdAccordianText;


    public AccordianPage testAccordians(){
        elementActions.clickElement(firstAccordianBtn);
        Assert.assertTrue(firstAccordianText.getAttribute("innerText").contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "));
        elementActions.clickElement(secAccordianBtn);
        Assert.assertTrue(secAccordianText.getAttribute("innerText").contains("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old."));
        elementActions.clickElement(thirdAccordianBtn);
        Assert.assertTrue(thirdAccordianText.getAttribute("innerText").contains("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', "));
        return this;
    }









}
