package com.ValidatingUrlAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingUrlAddress_GoogleHomepage {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		String applicationUrlAddress= "http:/google.com";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		
		 //Validating the Title of Google Homepage
		
		 String expected_GoogleHomepageTitle="Google";
		 System.out.println("The Expected Title of Google Homepage is:- "+expected_GoogleHomepageTitle);
		 
		 String actual_GoogleHomepageTitle=driver.getTitle();
		 System.out.println("The Actual TItle of Google HomePage is:- "+actual_GoogleHomepageTitle);
		 
		 if(actual_GoogleHomepageTitle.equalsIgnoreCase(actual_GoogleHomepageTitle))
		 {
			 System.out.println("The Google Homepage Title Matched- PASS");
		 }
		 else
		 {
			 System.out.println("The Google Homepage Title Not Matched - FAIL ");
		 }
		 
		 //**************************************************
			 
		//Capturing the Current URl Address of the Webpage
		
		 String expected_GoogleHomepageUrlAddress="google.com";
		 System.out.println("The Expected URL Address of Google Homepage is:- "+expected_GoogleHomepageUrlAddress);
		 
		 
		String actual_GoogleHomepageUrlAddress=driver.getCurrentUrl();
		System.out.println("The Actual URL Address of Google Homepage is:-"+actual_GoogleHomepageUrlAddress);
		
		if(actual_GoogleHomepageUrlAddress.contains(actual_GoogleHomepageUrlAddress))
		{
			System.out.println("The Url Address of Google Homepage Matched - PASS");
		}
		
		else
		{
			System.out.println("The Url Address of Google Homepage Not Matched - FAIL");
		}
		
		driver.quit();
	}

}
