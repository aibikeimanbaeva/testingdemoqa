package com.digital;

import org.testng.annotations.Test;

public class BrowserWindowPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/browser-windows");
        browserWindowPage.clickTabBtn().clickWindowBtn().clickMessageWindowBtn();
    }
}
