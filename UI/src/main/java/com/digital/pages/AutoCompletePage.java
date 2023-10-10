package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class AutoCompletePage extends BasePage {

    @FindBy(id = "autoCompleteMultipleInput")
    public WebElement multipleInput;

    @FindBy(xpath = "//div[@id='autoCompleteMultipleContainer']/div[2]")
    public List<WebElement> subjectList;


    @FindBy(id = "autoCompleteSingleInput")
    public WebElement singleInput;

    @FindBy(xpath = "//div[@id='autoCompleteSingleContainer']/div[2]")
    public List<WebElement> subjectList2;



    public AutoCompletePage selectSubject() {
        Random random = new Random();
        String[] randomChar = new String[]{"A", "S", "D", "G", "H", "L", "C", "V", "B", "N", "M", "E", "R", "T", "Y", "U", "I", "O", "P"};
        int randomIndex = random.nextInt(randomChar.length);
        String randomLetter = randomChar[randomIndex];
        elementActions.writeText(multipleInput, randomLetter);
        for (WebElement el : subjectList) {
            elementActions.waitElementToBeVisible(el);
        }
        elementActions.clickToRandomElement(subjectList);
        return this;
    }

    public AutoCompletePage selectSubject2() {
        Random random = new Random();
        String[] randomChar = new String[]{"A", "S", "D", "G", "H", "L", "C", "V", "B", "N", "M", "E", "R", "T", "Y", "U", "I", "O", "P"};
        int randomIndex = random.nextInt(randomChar.length);
        String randomLetter = randomChar[randomIndex];
        elementActions.writeText(singleInput, randomLetter);
        for (WebElement el : subjectList2) {
            elementActions.waitElementToBeVisible(el);
        }
        elementActions.clickToRandomElement(subjectList2);
        return this;
    }


}
