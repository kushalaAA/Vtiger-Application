package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	//Declaration
	
			@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement createCampaign;
			
			//Intialization//

			public CampaignPage(WebDriver driver) 
			{
				PageFactory.initElements(driver, this);
			}

			//utilization
			public WebElement getCreateCampaign() {
				return createCampaign;
			}
			
			//business logic//
			public void LookUpIcon() {
				createCampaign.click();
			}
}
