package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable_SingleTestData extends BaseTest {

	
	public void capturingFirstRowOfFirstCellValue() throws InterruptedException {
		
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		
		Thread.sleep(5000);
		// //*[@id="qc-cmp2-ui"]/div[2]/div/button[2]
		driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
		Thread.sleep(10000);
		
		By cityNameLocator = By.xpath("/html/body/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
		WebElement cityName = driver.findElement(cityNameLocator);
		String cityNameText= cityName.getText();
		System.out.println("The Name of City is:- "+cityNameText);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebTable_SingleTestData testData = new WebTable_SingleTestData();
		testData.applicationLaunch();
		testData.capturingFirstRowOfFirstCellValue();
		testData.applicationClose();
		
	}
}
