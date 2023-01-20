package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtility.WebDriverUtility;

public class Home{
	
	WebDriver driver;
	//declaration//
	
	@FindBy(linkText="Organizations")
	private WebElement organizationModule;
	
	@FindBy(linkText="Leads")
	private WebElement leadModule;
	
	@FindBy(linkText="Products")
	private WebElement productModule;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorModule;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesModule;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsModule;
	
	@FindBy(linkText="Recycle Bin")
	private WebElement recycleBinModule;
	
	@FindBy(linkText="FAQ")
	private WebElement faqModule;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(linkText="More")
	private WebElement moreModule;

	@FindBy(linkText="Campaigns")
	private WebElement campaignsModule;

	//Intialization//
	
	public Home(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//utilization//

    public WebElement getOrganizationModule() {
		return organizationModule;
	}

	public WebElement getLeadModule() {
		return leadModule;
	}

	public WebElement getProductModule() {
		return productModule;
	}

	public WebElement getVendorModule() {
		return vendorModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getRecycleBinModule() {
		return recycleBinModule;
	}

	public WebElement getFaqModule() {
		return faqModule;
	}
	
	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	public WebElement getCampaignsModule() {
		return campaignsModule;
	}
	
	public WebElement getMoreModule() {
		return moreModule;
	}
	
	//business logic//
	
	public void logout(WebDriverUtility wLib)
	{
		wLib.mousehover(driver, adminstratorImg);
		signOut.click();
	}
	
	public void organizationpage()
	{
		organizationModule.click();
	}
	
	public void recycleBinpage()
	{
		recycleBinModule.click();
	}
	
	public void contactspage()
	{
		contactsModule.click();
	}
	
	public void opportunitiespage()
	{
		opportunitiesModule.click();
	}
	
	public void vendorpage()
	{
		vendorModule.click();
	}
	
	public void faqpage()
	{
		faqModule.click();
	}
	
	public void productpage()
	{
		productModule.click();
	}
	
	public void leadpage()
	{
		leadModule.click();
	}	
	
	public void morepage(WebDriverUtility wLib)
	{
		wLib.mousehover(driver,moreModule);
	}
	
	public void campaignpage(WebDriverUtility wLib)
	{
		campaignsModule.click();
	}
}
