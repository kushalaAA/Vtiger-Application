package com.Vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.pomrepositorylib.Home;
import com.Vtiger.pomrepositorylib.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public DatabaseUtility dLib=new DatabaseUtility();	
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
@BeforeSuite
public void configDB() throws Throwable
{
//	dLib.connectionToDB();
	System.out.println("---Connect to DB---");
}

//@Parameters("BROWSER")
@BeforeClass
public void configBC() throws Throwable
{
	String BROWSER=fLib.readDataFromPropertyFile("browser");
	String URL=fLib.readDataFromPropertyFile("url");
	
	if(BROWSER.equalsIgnoreCase("edge"))
	{
		//WebDriver driver = WebDriverManager.firefoxdriver().create();
		System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
		driver = new EdgeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("chrome"))
	{ 
		driver =new ChromeDriver();
    }
	else
	{
		System.out.println("Invalid Browser");
	}
	
	sdriver=driver;
	wLib.maxiMizewindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	System.out.println("Launch the browser");	
}	

@BeforeMethod
public void configBM() throws Throwable 
{
	String USERNAME = fLib.readDataFromPropertyFile("username");
	String PASSWORD = fLib.readDataFromPropertyFile("password");
	Login lp=new Login(driver);
	lp.loginToApp(USERNAME, PASSWORD);	
	System.out.println("--Login to the application");
 }

@AfterMethod
public void confiAM() {
	Home hp=new Home(driver);
	hp.logout(wLib);
	System.out.println("--Logout from the application");
}

@AfterClass
public void configAC()
{
	driver.quit();
	System.out.println("--Close the browser");
}

@AfterSuite
public void disconnectDB() throws Throwable
{
//	dLib.closeDB();
	System.out.println("---Disconnect to DB---");
}

} 

  
 