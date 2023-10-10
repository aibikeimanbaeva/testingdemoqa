package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

public class WebTablesPage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewPersonBtn;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;
    @FindBy(id = "age")
    public WebElement ageInput;
    @FindBy(id = "salary")
    public WebElement salaryInput;
    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement sumbitFormBtn;

    @FindBy(id = "google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0")
    public WebElement frameHide;
    @FindBy(id = "searchBox")
    public WebElement searchInput;
    @FindBy(xpath = "//span[@title='Delete']")
    List<WebElement> listOfDeleteBtn;
    @FindBy(xpath = "//div[@class='rt-tr-group'][1]//div[@class='rt-td']")
    List<WebElement> personInfoFromTable;
    List<String> personInfo;

    String firstNameInputSearch;
    @FindBy(xpath = "//div[@class='rt-tr-group']//div")
    private WebElement tableTextForSearching;

    public void setSearchText(String searchText) {
        String xpath = "//div[@class='rt-tr-group']//div[contains(text(), '" + searchText + "')]";
        tableTextForSearching = Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebTablesPage checkDeleteBtn() {
        while (!listOfDeleteBtn.isEmpty()) {
            WebElement btn = listOfDeleteBtn.get(0); // Берем первый элемент из списка
            elementActions.clickByJS(btn);
        }
        return this;
    }

    public WebTablesPage hide() {
        elementActions.hideElementByJS(frameHide);
        return this;
    }

    public WebTablesPage openForm() {
        elementActions.clickElement(addNewPersonBtn);
        personInfo = new LinkedList<>();
        return this;
    }

    public WebTablesPage fillUpTheFirstName(String txt) {
        elementActions.writeText(firstNameInput, txt);
        personInfo.add(txt);
        firstNameInputSearch = txt;
        return this;
    }

    public WebTablesPage fillUpTheLastName(String txt) {
        elementActions.writeText(lastNameInput, txt);
        personInfo.add(txt);
        return this;
    }

    public WebTablesPage fillUpTheEmail(String txt) {
        elementActions.writeText(userEmailInput, txt);
        personInfo.add(txt);
        return this;
    }

    public WebTablesPage fillUpTheAge(String txt) {
        elementActions.writeText(ageInput, txt);
        personInfo.add(txt);
        return this;
    }

    public WebTablesPage fillUpTheSalary(String txt) {
        elementActions.writeText(salaryInput, txt);
        personInfo.add(txt);
        return this;
    }

    public WebTablesPage fillUpTheDepartment(String txt) {
        elementActions.writeText(departmentInput, txt);
        personInfo.add(txt);
        return this;
    }

    public WebTablesPage submitForm() {
        elementActions.clickElement(sumbitFormBtn);
        return this;
    }

    public WebTablesPage checkSearchBoxInput() {
        elementActions.writeText(searchInput, firstNameInputSearch);
        setSearchText(firstNameInputSearch);
        return this;
    }

    public WebTablesPage testSearchCheckbox() {
        Assert.assertTrue(tableTextForSearching.isDisplayed());
        searchInput.clear();
        return this;
    }


    public WebTablesPage testTable() {
        Set<String> personInfoTableSet = new TreeSet<>();
        Set<String> personInfoSet = new TreeSet<>();
        for (int i = 0; i < personInfoFromTable.size(); i++) {
            String text = personInfoFromTable.get(i).getText();
            if (!text.trim().isEmpty()) {
                personInfoTableSet.add(text);
            }
        }
        for (int i = 0; i < personInfo.size(); i++) {
            personInfoSet.add(personInfo.get(i));
        }
        Assert.assertEquals(personInfoTableSet, personInfoSet);
        return this;
    }

}
