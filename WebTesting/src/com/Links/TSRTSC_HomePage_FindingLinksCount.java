package com.Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTSC_HomePage_FindingLinksCount {
	
	public static void main(String[] args) {
		
		
		WebDriver driver;
		String applicationUrlAddress = "https://www.tsrtconline.in/oprs-web/?ref=w3use";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
		By tagNameLocator = By.tagName("a");
		/* 
		WebElement tsrtcHomePageLink= driver.findElement(tagNameLocator);
		String tsrtcLinkName = tsrtcHomePageLink.getText();
		System.out.println(tsrtcLinkName);
		*/
		
		List<WebElement>tsrtcHomePageLinks = driver.findElements(tagNameLocator);
		int tsrtcHomePageLinksSize= tsrtcHomePageLinks.size();
		System.out.println("THe total number of links in TSRTC Home Pge IS:- "+tsrtcHomePageLinksSize);
		
		
		//Getting the names of the links frpm Array list tsrtcHomePageLinks
		
		for(int index = 0;index<tsrtcHomePageLinksSize;index++)
		{
			String tsrtcHomePageLinkName = tsrtcHomePageLinks.get(index).getText();
			System.out.println(index+ " " +tsrtcHomePageLinkName);
		}
		driver.quit();
	}

}
