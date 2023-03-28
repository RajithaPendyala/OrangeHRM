package com.Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SignIn_Click {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		String applicatinUrlAddress = "https:/google.com";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
	    driver = new ChromeDriver();
	    
		driver.get(applicatinUrlAddress);
		/*
		<a class="gb_ga gb_ha gb_ce gb_cd"
				 href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ"
				 target="_top">Sign in</a>	
				 
		*/
		By signInLocator = By.linkText("Sign in");
		WebElement signIn = driver.findElement(signInLocator);
		signIn.click();
		
		//To get the Text of SignIn Webpage
		String signInElementText = signIn.getText();
		System.out.println("The Text of SignIn Webpage is :-"+signInElementText);
		signIn.click();
		
		String signInWebpageTitle = driver.getTitle();
		System.out.println("The Title of SignIn Webpage is:- "+signInWebpageTitle);
		
		
		
		
	}

}
