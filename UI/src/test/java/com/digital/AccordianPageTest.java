package com.digital;

import org.testng.annotations.Test;

public class AccordianPageTest extends BaseTest {
    @Test
    void test() {
        driver.get("https://demoqa.com/accordian");
        accordianPage.testAccordians();
    }
}
