package Contacts_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtility.ExcelUtility;
import com.Vtiger.genericUtility.FileUtility;
import com.Vtiger.genericUtility.JavaUtility;
import com.Vtiger.genericUtility.WebDriverUtility;
import com.Vtiger.pomrepositorylib.ContactsInfoPage;
import com.Vtiger.pomrepositorylib.ContactsPage;
import com.Vtiger.pomrepositorylib.CreateNewContactsPage;
import com.Vtiger.pomrepositorylib.Home;
import com.Vtiger.pomrepositorylib.Login;

public class CreateContactsTest {
		public static void main(String[] args) throws Throwable{
			
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
			
			String lastname=eLib.readDataFromExcelSheet("Contacts",0,1)+random;
			
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
			
			//Step:3 Navigate to Contacts
			Home hp=new Home(driver);
			hp.contactspage();
			
			//Step:4 Navigate to Contact Page
			ContactsPage cp=new ContactsPage(driver);
			cp.LookUpIcon();
			
			//Step:5 create new Contacts
			CreateNewContactsPage cnc=new CreateNewContactsPage(driver);
			cnc.createContact(lastname);
			
			//Step:6 Verify
			ContactsInfoPage cinfo=new ContactsInfoPage(driver);
			cinfo.getSuccessMsg();
			wLib.waitForPageLoad(driver);
			String actual = cinfo.getSuccessMsg().getText();
			if(actual.contains(lastname)) 
			{
				System.out.println("Contacts is created");
			}
			else
			{
				System.out.println("Contacts is not created");
			}
			
		    //Step:7 logout
			hp.logout(wLib);
			
			//Step:8 close the browser
			wLib.close(driver);
  }
}
