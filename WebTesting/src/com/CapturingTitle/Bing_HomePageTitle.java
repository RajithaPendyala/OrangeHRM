package com.CapturingTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_HomePageTitle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		//driver.get("http://bing.com");
		driver.navigate().to("http://bing.com");
		
		String actual_bingHomePageTitle = driver.getTitle();
		System.out.println("the title of Bing Homepage Title is:- "+actual_bingHomePageTitle);
		driver.quit();
	}
}
