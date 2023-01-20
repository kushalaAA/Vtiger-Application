package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.genericUtility.ExcelUtility;

public class DataProviderTest {
	
	@Test(dataProvider="getData")
	public void readData(String from, String to) {
		System.out.println(from+"----->"+to);
	}
		
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.readMultipleSetOfData("DataProvider");
		return value;
	}
	
}
