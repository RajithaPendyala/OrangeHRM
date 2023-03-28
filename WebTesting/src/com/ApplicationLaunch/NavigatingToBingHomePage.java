package com.ApplicationLaunch;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NavigatingToBingHomePage {
	
	public static void main(String[] args) {
		
		//Automating the Browser
		//System.setProperty("webdriver.chrome.browser", "./browserDriverFiles/chromedriver.exe");
		//ChromeDriver launchChromeBrowser = new ChromeDriver();
		
		//Navigating to Bing Homepage
		
		//launchChromeBrowser.get("http://bing.com");
		
		//Closing the Browser
		//launchChromeBrowser.close();
		
		System.setProperty("webdriver.edge.driver", "./browserDriverFiles/msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		
		driver.get("http://bing.com");
		driver.close();
		//driver.quit();
				
				
		
		
		
		
 
	}

}
