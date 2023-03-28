package com.ValidatingGoogleHomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingTitle_GoogleHomePage {
	
	public static void main(String[] args) {
	
		WebDriver driver;
		String applicationUrlAddress = "http:/google.com";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		String expected_GoogleHomepageTitle = "Google";
		
		
		System.out.println("The Expected Title of Google HomePage is:- "+expected_GoogleHomepageTitle);
		
		String actual_GoogleHomepageTitle= driver.getTitle();
		System.out.println("The first letter of the Actual Google Homepage Title is:- "+actual_GoogleHomepageTitle.charAt(0));
		
		System.out.println("The Actual Title of Google Homepage Title is:- "+actual_GoogleHomepageTitle);
		if(actual_GoogleHomepageTitle.equals(expected_GoogleHomepageTitle))
		{
			System.out.println("The Google Homepage Title Matched - PASS");
			
		}
		else
			
		{
			System.out.println("The Google Homepage Title Not Matched - FAIL");
		}
		driver.quit();
	}

}
