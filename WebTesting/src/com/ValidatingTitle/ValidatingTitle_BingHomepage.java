package com.ValidatingTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingTitle_BingHomepage {
	
public static void main(String[] args) {
	

	 String applicationUrlAddress = "http://bing.com";
	 WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		String expected_BingHomePageTitle = "Bing";
		System.out.println("The Actual Title of Bing HomePage is:- "+expected_BingHomePageTitle);
		
		
		String actual_BingHomePageTile= driver.getTitle();
		System.out.println("The Expected Title of Bing HomePage Title is:- "+actual_BingHomePageTile);
		
		if(actual_BingHomePageTile.equals(expected_BingHomePageTitle))
		{
		System.out.println("Bing HomePage Title Matched - PASS ");	
        }
		else
			
		{
			System.out.println("Bing HomePage Title  Not Matched - Fail" );
		}
		driver.quit();
}
}
