package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	//Declaration
	
		@FindBy(name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//Intialization//

		public CreateNewContactsPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
		//Utilization

		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}
		
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//business logic//
		public void createContact(String lastname) {
			lastNameEdt.sendKeys(lastname);			
			saveBtn.click();
		}	
}
