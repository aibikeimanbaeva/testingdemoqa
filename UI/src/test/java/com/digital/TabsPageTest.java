package com.digital;

import org.testng.annotations.Test;

public class TabsPageTest extends BaseTest {
    @Test
    void test() {
        driver.get("https://demoqa.com/tabs");
        tabsPage.clickToWhatTab().clickToOriginTab().clickToUseTab().clicktoMoreTab();
    }
}
