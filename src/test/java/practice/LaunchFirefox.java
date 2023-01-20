package practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFirefox {
	
public static void main(String[] args)  {
	
	WebDriver driver = WebDriverManager.firefoxdriver().create();
		
//		System.setProperty("webdriver.firefox.driver","./drivers/geckodriver.exe");
//		FirefoxDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.close();
	 }
	

}
