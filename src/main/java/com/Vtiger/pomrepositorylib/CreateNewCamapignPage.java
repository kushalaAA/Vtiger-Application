package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCamapignPage {
	    //Declaration
	    @FindBy(name="campaignname")
		private WebElement campaignnameEdt;
	    
	    @FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//Intialization//
        public CreateNewCamapignPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getCampaignnameEdt() {
			return campaignnameEdt;
		}
		
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Logic
		
		public void createCamapign(String campaigntname ) {
			campaignnameEdt.sendKeys(campaigntname);
			saveBtn.click();
		}	

}
