package com.OHRM_BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Utility.Log;


public class BaseTest {
	
	public WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	      	
	@BeforeTest
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\chromeDriverFile\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.out.println(" Chrome Browser Launched Successfully ");
		Log.info(" Chrome Browser Launched Successfully ");
		
		driver.get(applicationUrlAddress);
		//System.out.println(" Successfully entered OrangeHRM Application Url Address");
		Log.info(" Successfully entered OrangeHRM Application Url Address");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		// Implicit Wait- Global Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		//System.out.println(" OrangeHRM Application and the Browser Closed Successfully  ");
		Log.info("OrangeHRM Application and the Browser Closed Successfully");
	}
    
}