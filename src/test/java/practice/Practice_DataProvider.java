package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_DataProvider {
	
	@Test(dataProvider="data")
	public void travel(String src, String dst, int price) {
		System.out.println("From "+src+" to "+dst+" price value is "+price);
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0]="Bangalore";
		objarr[0][1]="Mysore";
		objarr[0][2]=100;
		
		objarr[1][0]="Mysore";
		objarr[1][1]="Bangalore";
		objarr[1][2]=120;
		
		objarr[2][0]="Mysore";
		objarr[2][1]="Hibli";
		objarr[2][2]=220;
		return objarr;			
	}	
}
