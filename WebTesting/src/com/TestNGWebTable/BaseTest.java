package com.TestNGWebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	String applicationUrlAddress = "https://www.timeanddate.com/worldclock/";
	
	@BeforeTest
	public void setUp() 
	{
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriverFile/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(applicationUrlAddress);
		
				
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}

}
