package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditNewLeadPage {

	//Declaration
	
	@FindBy(name="phone")
	private WebElement phoneNoEdt;
	
	@FindBy(name="mobile")
	private WebElement mobileNoEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Intialization//

		public EditNewLeadPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getPhoneNoEdt() {
			return phoneNoEdt;
		}

		public WebElement getMobileNoEdt() {
			return mobileNoEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Logic
		public void editLead(String phone,String mobile) {
			phoneNoEdt.sendKeys(phone);
			mobileNoEdt.sendKeys(mobile);
			saveBtn.click();
		}	
		
		
}
