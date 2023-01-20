package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {
	
	//Declaration
	
	@FindBy(name="salutationtype")
	private WebElement salutationEdt;
	
	@FindBy(name="firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="company")
	private WebElement companyNameEdt;
	
	@FindBy(name="phone")
	private WebElement phoneNoEdt;
	
	@FindBy(name="mobile")
	private WebElement mobileNoEdt;
	
	@FindBy(name="search_field")
	private WebElement searchTextEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement editBtn;
	
	//Intialization//

	public CreateNewLeadPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getSalutationEdt() {
		return salutationEdt;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}

	public WebElement getPhoneNoEdt() {
		return phoneNoEdt;
	}

	public WebElement getMobileNoEdt() {
		return mobileNoEdt;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}
	
	//business logic//
	public void createLead(String firstname,String lastname,String company ) {
		firstNameEdt.sendKeys(firstname);
		lastNameEdt.sendKeys(lastname);
		companyNameEdt.sendKeys(company);
		saveBtn.click();
		editBtn.click();
	}	
		
}
