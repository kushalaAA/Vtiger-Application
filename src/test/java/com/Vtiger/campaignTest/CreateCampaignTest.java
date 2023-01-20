package com.Vtiger.campaignTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;
import com.Vtiger.pomrepositorylib.CampaignInfoPage;
import com.Vtiger.pomrepositorylib.CampaignPage;
import com.Vtiger.pomrepositorylib.CreateNewCamapignPage;
import com.Vtiger.pomrepositorylib.Home;
import com.Vtiger.pomrepositorylib.LeadsInfoPage;
import com.Vtiger.pomrepositorylib.LeadsPage;
import com.Vtiger.pomrepositorylib.Login;

public class CreateCampaignTest {
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
		String campaigntname = eLib.readDataFromExcelSheet("Campaign",1 ,0)+random;
		
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
				
				//Step:3 Navigate to More & Campaign
				Home hp=new Home(driver);
				hp.morepage(wLib);
				hp.campaignpage(wLib);
				
				//Step:4 Navigate to Campaign Page
				CampaignPage cp=new CampaignPage(driver);
				cp.LookUpIcon();
					
				//Step:5 create new Campaign
				CreateNewCamapignPage cncp=new CreateNewCamapignPage(driver);
				cncp.createCamapign(campaigntname);		
				
				//Step:6 Verify
				CampaignInfoPage Cinfo=new CampaignInfoPage(driver);
				Cinfo.getSuccessMsg();
				wLib.waitForPageLoad(driver);
				String actual = Cinfo.getSuccessMsg().getText();
				if(actual.contains(campaigntname)) 
				{
					System.out.println("Campaign is created");
				}
				else
				{
					System.out.println("Campaign is not created");
				}
				//Step:7 logout
				hp.logout(wLib);
				
				//Step:8 close the browser
				wLib.close(driver);
		 				
 }
}
