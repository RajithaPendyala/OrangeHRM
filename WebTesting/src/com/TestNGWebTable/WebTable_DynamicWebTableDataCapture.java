package com.TestNGWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_DynamicWebTableDataCapture extends BaseTest {
	
@Test
public void dynamicWebTableDataCapture()
{
	
	//Identifying The WebTable
	// /html/body/div[5]/section[1]/div/section/div[1]/div/table
	
	By webTableLocator = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table");
	WebElement webTable = driver.findElement(webTableLocator);
	
	//Identifying the Rows in the WebTable
     List<WebElement>webTableRows = webTable.findElements(By.tagName("tr"));
     
     //System.out.println("The Number of Rows in a Webtable are:-"+webTableRows);
     
     //To goto to all the Rows in the Table
     for(int rowIndex = 0; rowIndex<webTableRows.size();rowIndex++)
     {
    	//Going to Each Row and finding the number of cells 
    	List<WebElement>rowOfCells= webTableRows.get(rowIndex).findElements(By.tagName("td"));
    	
    	for(int rowOfCellIndex= 0;rowOfCellIndex<rowOfCells.size();rowOfCellIndex++)
    	{
    		String data = rowOfCells.get(rowOfCellIndex).getText();
    		System.out.print(data+"  ");
    	}
    	System.out.println();
     }
	
	
}
}
