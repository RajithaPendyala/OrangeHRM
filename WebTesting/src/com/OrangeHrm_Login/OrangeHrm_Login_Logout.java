package com.OrangeHrm_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHrm_Login_Logout {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		//<input name="txtUsername" id="txtUsername" type="text">
		By txtUserNameLocator = By.id("txtUsername");
		WebElement userName = driver.findElement(txtUserNameLocator);
		userName.sendKeys("Rajitha");
		
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		By txtPasswordLocator = By.id("txtPassword");
		 WebElement passWord = driver.findElement(txtPasswordLocator);
		 passWord.sendKeys("Abhi090310@");
		 
		 //<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		 
		 By btnLoginLocator = By.id("btnLogin");
		WebElement loginButton = driver.findElement(btnLoginLocator);
		loginButton.click();
		
		//Identifying the property of "WelcomeAdmin" Element
		//id="welcome"
		By welcomeAdminLocator = By.id("welcome");
		WebElement welcomeAdmin = driver.findElement(welcomeAdminLocator);
		welcomeAdmin.click();
		
		//Actions action = new Actions(driver);
		//action.moveToElement(welcomeAdmin).build().perform();
		
		//Identifying the Property of Logout Element
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		Thread.sleep(5000);
		By logOutLocator = By.linkText("Logout");
	     WebElement logOut = driver.findElement(logOutLocator);
	    logOut.click();
		 
	
	}

}
