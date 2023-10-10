package com.digital;

import org.testng.annotations.Test;

public class AutoCompletePageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/auto-complete");
        autoCompletePage.selectSubject().selectSubject2();
    }
}
