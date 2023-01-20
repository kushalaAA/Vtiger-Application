package com.Vtiger.leadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;
import com.Vtiger.pomrepositorylib.CreateNewLeadPage;
import com.Vtiger.pomrepositorylib.EditNewLeadPage;
import com.Vtiger.pomrepositorylib.Home;
import com.Vtiger.pomrepositorylib.LeadsInfoPage;
import com.Vtiger.pomrepositorylib.LeadsPage;
import com.Vtiger.pomrepositorylib.Login;
import com.Vtiger.pomrepositorylib.OrganizationInfo;

public class CreateLeadsTest {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=null;
		
		//create objects
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//creating Random class
		int random = jLib.getRandom();
		
		//create common data
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		//read test data
		String salutation = eLib.readDataFromExcelSheet("Lead",0 ,1);
		String firstname = eLib.readDataFromExcelSheet("Lead",1 ,1)+random;
		String lastname= eLib.readDataFromExcelSheet("Lead",2 ,1)+random;
		String company= eLib.readDataFromExcelSheet("Lead",3 ,1);
		String phone = eLib.readDataFromExcelSheet("Lead",4 ,1);
		String mobile = eLib.readDataFromExcelSheet("Lead",5 ,1);
		String In = eLib.readDataFromExcelSheet("Lead",6 ,1);
		
		//Step:1 Launch the browser
		if(BROWSER.equals("chrome"))
		{
			System.out.println("Launch the chrome Browser");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Server!!");
		}
		
		wLib.maxiMizewindow(driver);
		
		//Step:2 Login to App
		driver.get(URL);

		Login lp=new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step:3 Navigate to Leads
		Home hp=new Home(driver);
		hp.leadpage();
		
		//Step:4 Navigate to Leads Page
		LeadsPage lp1=new LeadsPage(driver);
		lp1.LookUpIcon();	
		
		//Step:5 create new Lead
		CreateNewLeadPage cnl=new CreateNewLeadPage(driver);
		cnl.createLead(firstname, lastname, company);
		
		EditNewLeadPage enlp=new EditNewLeadPage(driver);
		enlp.editLead(phone, mobile);
		
		//Step:6 Verify
		LeadsInfoPage linfo=new LeadsInfoPage(driver);
		linfo.getSuccessMsg();
		wLib.waitForPageLoad(driver);
		String actual = linfo.getSuccessMsg().getText();
		if(actual.contains(firstname)) 
		{
			System.out.println("Lead is created");
		}
		else
		{
			System.out.println("Lead is not created");
		}
		
	    //Step:7 logout
		hp.logout(wLib);
		
		//Step:8 close the browser
		//driver.close();
		wLib.close(driver);
  }
}
