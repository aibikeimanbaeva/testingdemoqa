package com.digital;

import org.testng.annotations.Test;

public class NestedFramesPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/nestedframes");
        nestedFramesPage.swithToParentFrame();
    }
}
