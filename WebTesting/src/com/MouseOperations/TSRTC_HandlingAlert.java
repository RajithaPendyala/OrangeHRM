package com.MouseOperations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HandlingAlert {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver;
		String applicationUrlAddress = "https://www.tsrtconline.in/oprs-web/?ref=w3use";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
		//Identifying the property of CheckAvailability Button
		//id="searchBtn"
		
		By checkAvailabilityLocator = By.id("searchBtn");
		WebElement checkAvailability = driver.findElement(checkAvailabilityLocator);
		checkAvailability.click();
		Thread.sleep(5000);
		
		//Switching to the Alert from the Webpage
		
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		//Cancel Tickets
		
		By cancelTicketsLocator= By.linkText("Cancel Tickets");
		WebElement cancelTickets = driver.findElement(cancelTicketsLocator);
		cancelTickets.click();
		driver.quit();
		
	}

}
