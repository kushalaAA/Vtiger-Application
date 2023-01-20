package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
WebDriver driver;
	
	//Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement successMsg;
		
		//Intialization//
		
		public ContactsInfoPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
	    //Utilization
		public WebElement getSuccessMsg() {
			return successMsg;
		}	

}
