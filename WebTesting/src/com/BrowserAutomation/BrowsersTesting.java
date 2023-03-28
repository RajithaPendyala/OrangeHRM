package com.BrowserAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowsersTesting {
	
	public static void main(String[] args) {
		
		
		//Automating the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver obj = new ChromeDriver();
		
		//Automating Edge Browser
		System.setProperty("webdriver.edge.driver", "C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\browserDriverFiles\\msedgedriver.exe");
		EdgeDriver edgeBrowser = new EdgeDriver();
		
		
		//Automating Opera Browser
		 
		//System.setProperty("webdriver.opera.driver", "./browserDriverFiles/operadriver.exe");
		//OperaDriver operaBrowser = new OperaDriver();
		
		
		//Automating Firefox Browser
		//System.setProperty("webdriver.gecko.driver", "./browserDriverFiles/geckodriver.exe");
		//FirefoxDriver firefoxBrowser = new FirefoxDriver();
	}

}
