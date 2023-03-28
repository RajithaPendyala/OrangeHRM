package com.ScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_ScreenShot {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		String getApplicationUrlAddress = "https://www.bing.com/";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(getApplicationUrlAddress);
		
		File webPageScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(webPageScreenShot, new File("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\ApplicationScreenShots\\bingScreenshot.png"));
		
		driver.quit();
		
	}

}
