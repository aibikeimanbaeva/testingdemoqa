package com.digital;

import com.digital.models.Person;
import org.testng.annotations.Test;

public class WebTablesPageTest extends BaseTest {

    @Test
    void test() {
        driver.get("https://demoqa.com/webtables");
        Person person = fakeDataProvider.createFakePerson();
        webTablesPage
                .hide()
                .checkDeleteBtn()
                .openForm()
                .fillUpTheFirstName(person.getFirstName()).fillUpTheLastName(person.getLastName())
                .fillUpTheEmail(person.getEmail())
                .fillUpTheAge(person.getAge())
                .fillUpTheSalary(person.getAge())
                .fillUpTheDepartment(person.getDepartment())
                .submitForm()
                .testTable()
                .checkSearchBoxInput()
                .testSearchCheckbox();

    }
}
