package com.Vtiger.organizationTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.genericUtility.BaseClass;
import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;

import com.Vtiger.pomrepositorylib.CreateNewOrganizationPage;
import com.Vtiger.pomrepositorylib.Home;
import com.Vtiger.pomrepositorylib.Login;
import com.Vtiger.pomrepositorylib.OrganizationInfo;
import com.Vtiger.pomrepositorylib.Organizations;

@Listeners(com.Vtiger.genericUtility.ListnersImplementationClass.class)
public class CreateOrgUsingBaseClassTest extends BaseClass
{
	@Test(retryAnalyzer=com.Vtiger.genericUtility.RetryImplementationClass.class)
	public void creatOrg() throws Throwable
	{
//		WebDriver driver=null;
//	
//		//create objects
//		ExcelUtility eLib=new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//		
		//creating Random class
		int random = jLib.getRandom();
		
//		//create common data
//		String URL = fLib.readDataFromPropertyFile("url");
//		String USERNAME = fLib.readDataFromPropertyFile("username");
//		String PASSWORD = fLib.readDataFromPropertyFile("password");
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
//		
		//read test data
		String orgName = eLib.readDataFromExcelSheet("Organization",1,0)+random;
		
//		//Step:1 Launch the browser
//		if(BROWSER.equals("chrome"))
//		{
//			System.out.println("Launch the chrome Browser");
//			driver=new ChromeDriver();
//		}
//		else
//		{
//			System.out.println("Invalid Browser Server!!");
//		}
//		
//		wLib.maxiMizewindow(driver);
//		
//		//Step:2 Login to App
//		driver.get(URL);

//		Login lp=new Login(driver);
//		lp.loginToApp(USERNAME, PASSWORD);
 
		//Step:3 Navigate to Org
		Home hp=new Home(driver);
		hp.organizationpage();
//		assertEquals("A", "B");
		
		//Step:4 Navigate to create Org Page
		Organizations op=new Organizations(driver);
		op.LookUpIcon();
		
		//Step:5 create new Org
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(orgName);
		Thread.sleep(5000);
		
		//Step:6 Verify
//		OrganizationInfo oinfo=new OrganizationInfo(driver);
//		oinfo.getSuccessMsg();
//		wLib.waitForPageLoad(driver);
//		String actual = oinfo.getSuccessMsg().getText();
//		if(actual.contains(orgName)) 
//		{
//			System.out.println("Organization is created");
//		}
//		else
//		{
//			System.out.println("Organization is not created");
//		}
//				
//		//Step:7 logout
//		Thread.sleep(5000);
//		hp.logout(wLib);
//		
//		//Step:8 close the browser
//		//driver.close();
//		wLib.close(driver);
	 } 
}
