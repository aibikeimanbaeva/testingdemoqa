package com.digital;

import org.testng.annotations.Test;

public class DatePickerPageTest extends BaseTest{
    @Test
    void test(){
        driver.get("https://demoqa.com/date-picker");
        datePickerPage.checkSelectDateCalendar().checkDateAndTimeCalendar();
    }
}
