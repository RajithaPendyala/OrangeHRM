package com.OrangeHRMApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {
public static void main(String[] args) {
	
	WebDriver driver;
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login" ;
	System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.get(applicationUrlAddress);
	  
	  //<input name="txtUsername" id="txtUsername" type="text">
	  
	  //driver.findElement(By.id("txtUsername")).sendKeys("Rajitha");
	  
	String userNameTestData = "Rajitha";
	 String passwordTestData= "Abhi090310@";
	  
	  By userNameLocator = By.id("txtUsername");
	WebElement userName = driver.findElement(userNameLocator);
	 userName.sendKeys(userNameTestData);
	  
	 // <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	  //driver.findElement(By.id("txtPassword")).sendKeys("Abhi090310@");
	 
	By passwordLocator = By.name("txtPassword");
	WebElement password= driver.findElement(passwordLocator);
	password.sendKeys(passwordTestData);
	  
	  
	  //<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	  //driver.findElement(By.id("btnLogin")).click();
	 By logInButtonLocator = By.className("button");
	  WebElement loginButton= driver.findElement(logInButtonLocator);
	  loginButton.click();
     driver.quit();
	  
	  
}
	
	
}
