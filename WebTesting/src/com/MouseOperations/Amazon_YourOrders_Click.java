package com.MouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_YourOrders_Click {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		String applicationUrlAddress = "https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
		// Identifying the HelloSignIn Element
		//id="nav-link-accountList"
		
		By helloSignInLocator = By.id("nav-link-accountList");
		WebElement helloSignIn= driver.findElement(helloSignInLocator);
		
		//To perform Mouse Operation on HelloSignIn Element- Mouse Hover Operation
		Actions action = new Actions(driver);
		action.moveToElement(helloSignIn).build().perform();
		
		
		
		//Identifying  YourOrders Element
		//id="nav_prefetch_yourorders"
		By yourOrdersLocator = By.id("nav_prefetch_yourorders");
		WebElement yourOrders = driver.findElement(yourOrdersLocator);
		
		yourOrders.click();
		
		driver.quit();
		
	}

	
}
