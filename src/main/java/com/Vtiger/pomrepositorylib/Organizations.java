package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	//Declaration
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganization;
	
	//Intialization//

	public Organizations(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
		
	//utilization
	public WebElement getCreateOrganization() {
	  return createOrganization;
	}
	
	//business logic//
	public void LookUpIcon() {
		createOrganization.click();
		
	}	
}
