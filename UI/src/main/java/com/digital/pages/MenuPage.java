package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuPage extends BasePage {


    @FindBy(xpath = "//ul[@id='nav']/li")
    public List<WebElement> menuList;


    @FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li")
    public List<WebElement> menuListItem2;

    @FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li[3]/ul/li/a")
    public List<WebElement> menuInMenuListItem2;
    public MenuPage checkHoverInMenuList() {
        for (int i = 0; i < menuList.size(); i++) {
            elementActions.moveToElement(menuList.get(i));
            elementActions.checkHoverEffect(menuList.get(i), "background");
            if (i == 1) {
                for (int z = 0; z < menuListItem2.size(); z++) {
                    elementActions.moveToElement(menuListItem2.get(z));
                    elementActions.checkHoverEffect(menuListItem2.get(z), "background");
                    if (z == 3) {
                        for (int j = 0; j < menuInMenuListItem2.size(); j++) {
                            elementActions.moveToElement(menuInMenuListItem2.get(j));
                            elementActions.checkHoverEffect(menuInMenuListItem2.get(j), "background");
                        }
                    }
                }
            }
        }
        return this;
    }



}
