package practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {
	
	@BeforeMethod
	public void Org()
	{
		System.out.println("--Login to the application");

    }
	
	@Test
	public void CreateOrg()
	{
		System.out.println("Navigate to the URL");
		System.out.println("Create Organization");
    }
	
	@Test(priority = 1,invocationCount=2)
	public void CreateContact()
	{
		System.out.println("Navigate to the URL");
		System.out.println("Create Contacts");
    }
	
	@AfterMethod
	public void Con()
	{
		System.out.println("--Logot from the application");

    }
	
}
