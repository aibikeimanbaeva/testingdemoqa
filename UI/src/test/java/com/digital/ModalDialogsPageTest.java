package com.digital;

import org.testng.annotations.Test;

public class ModalDialogsPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/modal-dialogs");
        modalDialogsPage.openSmallModal().openLargeModal();
    }
}
