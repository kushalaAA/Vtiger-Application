package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//Declaration//
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Intialization//
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization//
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business logic//
	
	public void loginToApp(String userName, String password) {
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}	  
}
