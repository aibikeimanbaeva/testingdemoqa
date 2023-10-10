package com.digital;

import org.testng.annotations.Test;

public class AlertPageTest extends BaseTest {

    @Test
    void  testAlertsPage(){
        driver.get("https://demoqa.com/alerts");
        alertsPage.clickBtnToSeeAlert().clickWithTimer().clickToConfirm().clickToWriteInPromt("hello world!");
    }

}
