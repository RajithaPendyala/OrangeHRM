package com.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	WebDriver driver;
	String applicationUrlAddress = "https://www.timeanddate.com/worldclock/";
	
	public void applicationLaunch() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriverFile/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(applicationUrlAddress);
		
				
	}
	
	public void applicationClose() {
		
		driver.quit();
		
	}

}
