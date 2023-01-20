package withouthardCodeTestScript;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;


public class CreateOrganizationWithOutHardCode {
public static void main(String[] args) throws Throwable {
		
		WebDriver driver=null;
		
		//creating the object of generic utility//
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//calling Random class
		
		int random = jLib.getRandom();
		
		//Calling  common data
		
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		//calling data from excel sheet//
		
		String organization_name=eLib.readDataFromExcelSheet("Organization",1 ,0)+random;
		
		//launching the browser//
		
		//WebDriver driver=new ChromeDriver();
		if(BROWSER.equals("chrome"))
		{
			System.out.println("Launch the chrome Browser");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Server!!");
		}
		
		//driver.manage().window().maximize();
		wLib.maxiMizewindow(driver);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wLib.waitForPageLoad(driver);
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//click on organization//
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on lookup image and fill all the details//
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organization_name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation//
		String created_organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(created_organization.contains(organization_name))
		{
			System.out.println(organization_name+" organization created successfully!");
			
		}
		else
		{
			System.out.println("Organization is not created!!");
		}
		
		//logout from the applications//
        WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
        wLib.mousehover(driver, signout);
        
		driver.findElement(By.linkText("Sign Out")).click();
		
		//driver.close();
		wLib.close(driver);
	}

}
