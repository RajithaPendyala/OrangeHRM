package com.Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TSRTC_HeaderBlock_Test {

	public static void main(String[] args) {
		
		WebDriver driver;
		String applicationUrlAddress = "https://www.tsrtconline.in/oprs-web/?ref=w3use";
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
		
		//class = "menu-wrap"
		
		//Finding the Header Block
		By HeaderBlockLocator = By.className("menu-wrap");
		WebElement HeaderBlock = driver.findElement(HeaderBlockLocator);
		
		//Finding the Elements in the Header Block
		
		By HeaderBlockElementLocator = By.tagName("a");
		List<WebElement>HeaderBlockLinks = HeaderBlock.findElements(HeaderBlockElementLocator);
		
		//Getting the count of the Elements in the Header Block
		int HeaderBlockLinksCount= HeaderBlockLinks.size();
		System.out.println("The number of Links In the Header Block is:- "+HeaderBlockLinksCount);
		
		for(int index=0;index<HeaderBlockLinksCount;index++)
		{
			String HeaderBlockLinkName= HeaderBlockLinks.get(index).getText();
			System.out.println(index+" "+HeaderBlockLinkName);
			
			
			String expected_HeaderBlockLinkUrlAddress= HeaderBlockLinks.get(index).getAttribute("href");
			System.out.println("The Expected Url Address is:-"+expected_HeaderBlockLinkUrlAddress);
			
			//Performing the Click Operation on the Link
			HeaderBlockLinks.get(index).click();
			
			//Getting the Title of The Webpage
			String actualTsrtcWebPageTitle = driver.getTitle();
			System.out.println("The title of the Webpage is:- "+actualTsrtcWebPageTitle);
			
			String actualTsrtcWebPageUrl = driver.getCurrentUrl();
			System.out.println("The Actual Url of the Webpage is:- "+actualTsrtcWebPageUrl);
			
			if(actualTsrtcWebPageUrl.equals(expected_HeaderBlockLinkUrlAddress))
			{
				System.out.println("Succussfully Navigated to the Expected Url-Pass");
			}
			else
			{
				System.out.println("Failed to Navigate to the Expected Url- Fail");
			}
			
			System.out.println();
			//Getting the driver Back to the Previous Webpage from Current Webpage
			
			driver.navigate().back();
			
			//Recreating the ArrayList
			HeaderBlock = driver.findElement(HeaderBlockLocator);
			HeaderBlockLinks = HeaderBlock.findElements(HeaderBlockElementLocator);
			
			
		}
		
		driver.quit();
	}
	
}
