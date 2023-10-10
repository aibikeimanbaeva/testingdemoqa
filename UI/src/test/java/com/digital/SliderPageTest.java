package com.digital;

import org.testng.annotations.Test;

public class SliderPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/slider");
        sliderPage.chooseRange().test();
    }
}
