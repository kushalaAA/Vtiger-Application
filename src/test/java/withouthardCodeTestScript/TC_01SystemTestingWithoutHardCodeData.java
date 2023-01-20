package withouthardCodeTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;

public class TC_01SystemTestingWithoutHardCodeData {
	static WebDriver driver=null;
	
	public static void main(String[] args) throws Throwable {
		
		//create object to library
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		//creating Random class
//		Random r=new Random();
//		int random = r.nextInt(100);
		int random = jLib.getRandom();
		
		//get common data
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String URL = pobj.getProperty("url");
//		String USERNAME = pobj.getProperty("username");
//		String PASSWORD = pobj.getProperty("password");
//		String BROWSER = pobj.getProperty("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
				
		//get data from excel sheet//
//		FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook book = WorkbookFactory.create(fi);
//		Sheet sh = book.getSheet("Lead");
//		String salutation = sh.getRow(0).getCell(1).getStringCellValue();
//		String firstname = sh.getRow(1).getCell(1).getStringCellValue()+random;
//		String lastname = sh.getRow(2).getCell(1).getStringCellValue()+random;
//		String company = sh.getRow(3).getCell(1).getStringCellValue();
//		String phone = sh.getRow(4).getCell(1).getStringCellValue();
//		String mobile = sh.getRow(5).getCell(1).getStringCellValue();
//		String In = sh.getRow(6).getCell(1).getStringCellValue();
		String salutation = eLib.readDataFromExcelSheet("Lead",0 ,1);
		String firstname = eLib.readDataFromExcelSheet("Lead",1 ,1)+random;
		String lastname= eLib.readDataFromExcelSheet("Lead",2 ,1)+random;
		String company= eLib.readDataFromExcelSheet("Lead",3 ,1);
		String phone = eLib.readDataFromExcelSheet("Lead",4 ,1);
		String mobile = eLib.readDataFromExcelSheet("Lead",5 ,1);
		String In = eLib.readDataFromExcelSheet("Lead",6 ,1);
		
		//launching the browser//
//		WebDriver driver=new ChromeDriver();
		if(BROWSER.equals("chrome")) 
		{
			System.out.println("Launch the chrome Browser");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Server!!");
		}
//		driver.manage().window().maximize();
		wLib.maxiMizewindow(driver);
		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wLib.waitForPageLoad(driver);
		
		driver.get(URL);
		
		//login to the applications//
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//Click on lead module//
		driver.findElement(By.linkText("Leads")).click();
		
		//click on create module//
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		WebElement salute = driver.findElement(By.name("salutationtype"));
//		Select s=new Select(salute);
//		s.selectByVisibleText(salutation);
		wLib.select(salutation, salute);
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("company")).sendKeys(company);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		
		//click on edit//
		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		
		//adding mobile and phone number//
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Click on lead module//
	    driver.findElement(By.linkText("Leads")).click();
	    
	    //click on in//
	    WebElement dd = driver.findElement(By.name("search_field"));
//	    Select s1=new Select(dd);
//	    s1.selectByValue(In);
	    wLib.select(dd, In);
	    
	    //click on search//
	    driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(firstname);
	    
	    //click on search now//
	    driver.findElement(By.name("submit")).click();
	    Thread.sleep(2000);
	    
	    //logout from the applications//
        WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
//		Actions act=new Actions(driver);
//		act.moveToElement(signout).perform();
        wLib.mousehover(driver, signout);
        
		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();
		wLib.close(driver);
	}

}
