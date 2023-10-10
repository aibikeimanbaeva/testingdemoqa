package com.digital;

import org.testng.annotations.Test;

public class RadioButtonPageTest extends BaseTest {
    @Test
    void testRadioBtn() {
        driver.get("https://demoqa.com/radio-button");
        radioButtonPage.clickYesBtn()
                .clickImpessiveBtn()
                .clickNoBtn();


    }
}
