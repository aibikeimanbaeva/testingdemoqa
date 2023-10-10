package com.digital;

import org.testng.annotations.Test;

public class DroppablePageTest extends BaseTest{
    @Test
    void test(){
        driver.get("https://demoqa.com/droppable");
        droppablePage
                .moveDraggableBlock()
                .checkDroppableBlock()
                .checkDroppableColor()
                .checkAcceptableBlockColor()
                .checkOuterDroppableBlock()
                .checkHoverInOuterDroppableBlock()
                .checkHoverInInnerDroppableBlock()
                .checkRevertableBtn()
                .checkNotRevertableBtn();
    }
}
