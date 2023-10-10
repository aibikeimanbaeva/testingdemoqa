package com.digital;

import org.testng.annotations.Test;

public class DraggablePageTest extends BaseTest {
    @Test
    void test() {
        driver.get("https://demoqa.com/dragabble");
        draggablePage.moveDragMeBox().checkOnlyXBox().checkOnlyYBox().checkContainmentWrapper().checkContainmentHeader();
    }
}
