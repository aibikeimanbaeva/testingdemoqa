package com.digital;

import org.testng.annotations.Test;

public class ButtonPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/buttons");
        buttonPage.makeDoubleClick().makeRightClick().makeSimpleClick().testButtons();
    }
}
