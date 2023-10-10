package com.digital;

import org.testng.annotations.Test;

public class SelectMenuPageTest extends BaseTest{
    @Test
    void test(){
        driver.get("https://demoqa.com/select-menu");
        selectMenuPage.checkSelectOption().checkSelectOne().checkSelect().checkMultiSelect().checkSelectCar();
    }
}
