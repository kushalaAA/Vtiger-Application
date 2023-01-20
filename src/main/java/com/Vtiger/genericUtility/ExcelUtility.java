package com.Vtiger.genericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility {
	/**
	 * This method is used to read data from excel sheet
	 * @author admin
	 * @param Sheetname
	 * @param rownum
	 * @param cellnum*
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcelSheet(String Sheetname,int rownum, int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		//Cell cel = row.getCell(cellnum);
		//String value = cel.getStringCellValue();
		return value;
	}
	/**
	 * This method is used to write data into excel sheet//
	 * @author admin
	 * @param Sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcelSheet(String Sheetname,int rownum, int cellnum,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		Row row = sh.createRow(rownum);
		Cell cel = row.createCell(cellnum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstant.Excelspath);
		book.write(fos);
	}
	
	//getLatRow or getRowCount 
	public int getLastRow(String Sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		return count;
    }
	
	//getLatCell or getCellCount 
	public int getLastCell(String Sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		int count = sh.getRow(0).getLastCellNum();
		return count;
    }
	
	//Reading multiple data from excel sheet with random number using Hashmap
	public HashMap<String,String> getList(String Sheetname,int keyCell,int valuecell) throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		int random = jLib.getRandom();
		
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valuecell).getStringCellValue()+random;
			map.put(key, value);
		}
		return map;
		
	}
	
	//Reading multiple data from excel sheet without random number using Hashmap
	public HashMap<String,String> getListWithoutRandom(String Sheetname,int keyCell,int valuecell) throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		WebDriver driver = null;
		
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valuecell).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String ,String> set: map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		return map;
	}
	
	//Reading multiple data from excel sheet with array list
	public ArrayList<String> getArrayList(String Sheetname,int cellno) throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	    FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet(Sheetname);
		int lastrownum = sh.getLastRowNum();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<=lastrownum;i++)
		{
			String value = sh.getRow(i).getCell(cellno).getStringCellValue();
			list.add(value);
		}
		return list;
	}
	
	//Checking web element by using multiple data using data provider
	public Object[][] readMultipleSetOfData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.Excelspath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++) 
		{
			for(int j=0;j<lastCell; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
		return obj;
	}
}
