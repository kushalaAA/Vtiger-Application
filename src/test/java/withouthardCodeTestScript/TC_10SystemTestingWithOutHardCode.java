package withouthardCodeTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;


public class TC_10SystemTestingWithOutHardCode {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= null;
		
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		int random = jLib.getRandom();
		
		String dropdown = eLib.readDataFromExcelSheet("Workflow",1, 0);
		
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		
		if(BROWSER.equals("chrome"))
		{	
			System.out.println("Chrome driver Launched Succesfully");
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		wLib.maxiMizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//login to vtiger
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//move to setting and click crm settings
		WebElement crmsetting = driver.findElement(By.xpath("//td[@class='genHeaderSmall']/../td[4]/img[1]"));
		wLib.mousehover(driver, crmsetting);
		driver.findElement(By.linkText("CRM Settings")).click();
		
		
		//scroll upto workflows
		WebElement workflows = driver.findElement(By.xpath("//a[contains(.,'Workflows')]"));
		wLib.scrollIntoView(driver, workflows);
		
		workflows.click();
		
		//module list dropdown and select list option and create
		driver.findElement(By.id("new_workflow")).click();
		WebElement moduledd = driver.findElement(By.id("module_list"));
		wLib.select(dropdown, moduledd);
		
		//click on create//
		driver.findElement(By.id("new_workflow_popup_save")).click();
	
		//Fetch data from excel
		String actualDescription=eLib.readDataFromExcelSheet("Workflow", 3, 1)+random;
		
		//write on description the data fetch from excel
		driver.findElement(By.id("save_description")).sendKeys(actualDescription);
		
		//click on save button
		driver.findElement(By.id("save_submit")).click();
		
		//again scroll down upto workflow
		wLib.scrollBarAction(driver);
		
		//click on workflows
		driver.findElement(By.xpath("//a[contains(.,'Workflows' )]")).click();
		
		//Again scroll down
		WebElement scrolllastoption = driver.findElement(By.xpath("//td[.='"+actualDescription+"']"));
		wLib.scrollIntoView(driver, scrolllastoption);
		
		//validation
		String expDescription=scrolllastoption.getText();
		if(actualDescription.equals(expDescription))
		{
			System.out.println("TC is pass");
			//delete that particular lead
			driver.findElement(By.xpath("//table[@id='expressionlist']/descendant::td[.='"+actualDescription+"']/../td[3]/a[2]")).click();
			wLib.acceptAlert(driver);
		}
		else
		{
			System.out.println("TC is fail");
		}	
		wLib.close(driver);
	}

}
