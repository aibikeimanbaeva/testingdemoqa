package com.digital;

import org.testng.annotations.Test;

public class SortablePageTest extends BaseTest{

    @Test
    void test(){
        driver.get("https://demoqa.com/sortable");
        sortablePage.moveElementsInList().moveElementsInGrid();
    }
}
