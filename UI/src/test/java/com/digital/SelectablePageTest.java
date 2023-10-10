package com.digital;

import org.testng.annotations.Test;

public class SelectablePageTest extends BaseTest{
    @Test
    void test(){
        driver.get("https://demoqa.com/selectable");
        selectablePage.checkItemInVerticalDiv().checkItemInGridDiv();
    }
}
