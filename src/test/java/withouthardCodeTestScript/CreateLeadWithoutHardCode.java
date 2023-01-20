package withouthardCodeTestScript;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;

public class CreateLeadWithoutHardCode {
	public static void main(String[] args) {
		
		//create object to library
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		WebDriver driver=new ChromeDriver();
		
		//driver.manage().window().maximize();
		wLib.maxiMizewindow(driver);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wLib.waitForPageLoad(driver);
		
		driver.get("http://localhost:8888/");
		
		//login to the application//
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//click on lead module//
		driver.findElement(By.linkText("Leads")).click();
		
		//click on lookup icon//
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		//lastname//
		driver.findElement(By.name("lastname")).sendKeys("jain");
		
		//company//
		driver.findElement(By.name("company")).sendKeys("jain community");
		
		//click on save//
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//click on edit button//
		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		
		//phone number//
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		
		//click on save//
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation//
		String expectedResult = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String actualResult="jain";
		if(expectedResult.contains(actualResult))
		{
			System.out.println("Lead is created!!!");
		}
		else
		{
			System.out.println("Lead is not creadted!!!!");
		}
		
		//close//
		//driver.close();
		wLib.close(driver);

	}
}
