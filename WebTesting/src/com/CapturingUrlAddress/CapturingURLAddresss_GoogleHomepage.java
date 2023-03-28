package com.CapturingUrlAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingURLAddresss_GoogleHomepage {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		String applicationUrlAddress= "http:/google.com";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		
		//Capturing the Current URl Address of the Webpage
		
		String actual_GoogleHomepageUrlAddress=driver.getCurrentUrl();
		System.out.println("The Actual URL Address of Google Homepage is:-"+actual_GoogleHomepageUrlAddress);
		driver.quit();
		
		
	}

}
