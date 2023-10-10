package com.digital;

import org.testng.annotations.Test;

public class ResizblePageTest extends BaseTest{
    @Test
    void test(){
        driver.get("https://demoqa.com/resizable");
        resizblePage.checkFirstResizbleDiv().checkSecondResizbleDiv();
    }
}
