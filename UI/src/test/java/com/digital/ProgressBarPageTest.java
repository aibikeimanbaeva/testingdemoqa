package com.digital;

import org.testng.annotations.Test;

public class ProgressBarPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/progress-bar");
        progressBarPage.clickToStartBtn();
    }

}
