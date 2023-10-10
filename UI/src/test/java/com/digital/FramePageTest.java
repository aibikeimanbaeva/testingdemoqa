package com.digital;

import org.testng.annotations.Test;

public class FramePageTest extends BaseTest {

    @Test
    void testFrames(){
        driver.get("https://demoqa.com/frames");
        framePage.switchToFirstFrame().switchToSecondFrame();
    }
}
