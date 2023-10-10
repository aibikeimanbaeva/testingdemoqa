package com.digital;

import org.testng.annotations.Test;

public class ToolTipsPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/tool-tips");
        toolTipsPage.checkHoverBtn().checkHoverTextField().checkHoverLink();
    }
}
