package com.TestNGWebTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_DynamicWebTableDataCapture_ExportToExcel extends BaseTest {
	
	@Test
	public void dynamicWebTableDataCapture() throws IOException
	{
		
		FileInputStream inputStreamFile = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\WebTable.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStreamFile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
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
	    	 
	    	Row newRow = sheet.createRow(rowIndex);
	    	//Going to Each Row and finding the number of cells 
	    	List<WebElement>rowOfCells= webTableRows.get(rowIndex).findElements(By.tagName("td"));
	    	
	    	for(int rowOfCellIndex= 0;rowOfCellIndex<rowOfCells.size();rowOfCellIndex++)
	    	{
	    		Cell newRowOfCell = newRow.createCell(rowOfCellIndex);
	    		
	    		//To go to the Row Of Cell and Get the Text of it
	    		String data = rowOfCells.get(rowOfCellIndex).getText();
	    		System.out.print(data+"  ");
	    		newRowOfCell.setCellValue(data);
	    		
	    		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\WebTable.xlsx");
	    		workbook.write(fileOutputStream);
	    	}
	    	System.out.println();
	     }
		
		
	}

}
