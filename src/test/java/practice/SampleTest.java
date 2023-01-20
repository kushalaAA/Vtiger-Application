package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

//(priority =0)
//(dependsOnMethods = "method name")
//(enabled = false)
//(invocationCount = 1)

public class SampleTest {
	
	@Test
	public void create()
	{
		Reporter.log("created", true);
	}
	
	@Test(dependsOnMethods = "delete")
	public void update()
	{
		System.out.println("updated");
	}
	
	@Test
	public void delete()
	{
		System.out.println("deleted");
	}
	
}
