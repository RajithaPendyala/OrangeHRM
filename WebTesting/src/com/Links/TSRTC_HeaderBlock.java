package com.Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HeaderBlock {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		String applicationURLAddress = "https://www.tsrtconline.in/oprs-web/?ref=w3use";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(applicationURLAddress);
		
		//Identifying the Header Block Of TSRTC Web Page
		//class = "menu-wrap"
		
		By tsrtcHeaderBlockLocator = By.className("menu-wrap");
		WebElement tsrtcHeaderBlock = driver.findElement(tsrtcHeaderBlockLocator);
		
		//Identifying the Elements of the Header Block
		
		 By headerBlockLinksLocator = By.tagName("a");
		 List<WebElement>tsrtcHeaderBlockLinks = tsrtcHeaderBlock.findElements(headerBlockLinksLocator);
		int tsrtcHeaderBlockLinksCount= tsrtcHeaderBlockLinks.size();
		 System.out.println("The number of links in TSRTC Web Page Header Block is:-" +tsrtcHeaderBlockLinksCount );
		 
		 for(int index = 0; index<tsrtcHeaderBlockLinksCount;index++)
			 
		 {
			 String tsrtcHeaderBlockLinkName = tsrtcHeaderBlockLinks.get(index).getText();
			 System.out.println(index+ " " +tsrtcHeaderBlockLinkName);
		 }
		 driver.quit();
	}

}
