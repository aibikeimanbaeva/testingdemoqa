package com.digital;

import org.testng.annotations.Test;

public class MenuPageTest extends BaseTest{
    @Test
    void test(){
        driver.get("https://demoqa.com/menu");
        menuPage.checkHoverInMenuList();
    }
}
