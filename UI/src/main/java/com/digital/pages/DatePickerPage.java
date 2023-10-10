package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DatePickerPage extends BasePage{
    @FindBy (id = "datePickerMonthYearInput")
    public WebElement selectDateInput;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement selectMonth;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement selectYear;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[contains(@class, 'react-datepicker__day')]")
    public List<WebElement> selectDayList;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement dateAndTimeInput;

    @FindBy(xpath = "//span[@class='react-datepicker__month-read-view--selected-month']")
    public WebElement openMonthList;
    @FindBy(xpath = "//span[@class='react-datepicker__year-read-view--selected-year']")
    public WebElement openYearList;

    @FindBy(xpath = "//div[@class='react-datepicker__month-dropdown']/div")
    public List<WebElement> monthOfSecDatePicker;
    @FindBy(xpath = "//div[@class='react-datepicker__year-dropdown']/div")
    public List<WebElement> yearOfSecDatePicker;
    @FindBy(xpath = "//div[@class='react-datepicker__month']/div/div")
    public List<WebElement> dayOfSecDatePicker;

    @FindBy(xpath = "//ul[@class='react-datepicker__time-list']/li")
    public List<WebElement> timeOfSecDatePicker;
    public DatePickerPage checkSelectDateCalendar(){
        elementActions.clickElement(selectDateInput);
        elementActions.selectRandomInSelect(selectMonth);
        elementActions.selectRandomInSelect(selectYear);
        elementActions.clickToRandomElement(selectDayList);
        Assert.assertNotNull(selectDateInput.getAttribute("innerText"));
        return this;
    }

    public DatePickerPage checkDateAndTimeCalendar(){
        elementActions.clickElement(dateAndTimeInput);
        elementActions.clickElement(openMonthList);
        elementActions.clickToRandomElement(monthOfSecDatePicker);
        elementActions.clickElement(openYearList);
        elementActions.clickToRandomElement(yearOfSecDatePicker);
        elementActions.clickToRandomElement(dayOfSecDatePicker);
        elementActions.clickToRandomElement(timeOfSecDatePicker);
        Assert.assertNotNull(dateAndTimeInput.getAttribute("innerText"));
        return this;

    }
}
