package com.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tsrtc_ScreenShot {
	
	public static void main(String[] args) throws IOException {
		
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
		for(int index=0;index<HeaderBlockLinksCount;index++)
		{
			HeaderBlockLinks.get(index).click();
			File ScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ScreenShot, new File("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\ApplicationScreenShots\\"));
		}
	}

}
