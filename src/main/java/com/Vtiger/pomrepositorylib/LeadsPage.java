package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	//Declaration
	
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createLead;
		
		//Intialization//

		public LeadsPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getCreateLead() {
			return createLead;
		}
		
		//business logic//
		public void LookUpIcon() {
			createLead.click();
		}
}
