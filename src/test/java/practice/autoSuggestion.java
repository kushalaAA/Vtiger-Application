package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestion {

	public static void main(String[] args) {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("https://www.google.co.in/");
//		driver.findElement(By.name("q")).sendKeys("virat kohli");
//	
//		List<WebElement> viratkohli = driver.findElements(By.xpath("//div[@class='erkvQe']/descendant::ul[@role='listbox']"));
//        //fetching all the autosuggestion//
//		for(WebElement vk:viratkohli)
//		{
//			String kingKohli = vk.getText();
//			System.out.println(kingKohli);
//		}
//		driver.close();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("virat kohli");
	
		 List<WebElement> viratkohli = driver.findElements(By.xpath("//div[@class='erkvQe']/descendant::ul[@role='listbox']"));
		 
		 //fetching all the autosuggestion//
		for(WebElement vk:viratkohli)
		{
			String kingKohli = vk.getText();
			System.out.println(kingKohli);
	    }
		driver.close();
	}  
}
