package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

   @FindBy(id = "alertButton")
   public WebElement toSeeAlertBtn;
   @FindBy(id="timerAlertButton")
   public  WebElement timeAlertBtn;

   @FindBy(id="confirmButton")
   public  WebElement confirmBtn;

   @FindBy(id="promtButton")
   public  WebElement promtBtn;

   public AlertPage clickBtnToSeeAlert(){
      elementActions.clickElement(toSeeAlertBtn);
       alertHelper.acceptAlert();
      return this;
   }
   public AlertPage clickWithTimer(){
      elementActions.clickElement(timeAlertBtn);
      alertHelper.acceptAlert();
      return this;
   }

   public AlertPage clickToConfirm(){
      elementActions.clickElement(confirmBtn);
      alertHelper.acceptAlert();
      return this;
   }

   public AlertPage clickToWriteInPromt(String txt){
      elementActions.clickElement(promtBtn);
      alertHelper.acceptPrompt(txt);
      return this;
   }


}
