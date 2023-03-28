package com.TestNGWebTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_ExportCompleteWebTableData extends BaseTest 
{
	@Test(description = "Exporting Complete Webtable Data to Excel Sheet")
	public void exportCompleteWebTableData() throws IOException
	{
		
		FileInputStream excelFileInputStream = new FileInputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\WebTable.xlsx"); 	
		XSSFWorkbook workBook = new XSSFWorkbook(excelFileInputStream); 
		XSSFSheet sheet = workBook.getSheet("Sheet1");	
		// First Row of First Column
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
		// Last Row of Last Column
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		
		String xpathExpressionPart1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["; 	
		String xpathExpressionPart2="]/td["; 
		String xpathExpressionPart3="]";
		
		// Identifying the Number of Active Rows 
		int rowsCount = sheet.getLastRowNum();
		
		// to goto Every Row 		
		for(int rowIndex=1;rowIndex<=rowsCount;rowIndex++) 	
		{ 		
			// creating a new Row 		
			Row row=sheet.createRow(rowIndex); 		
			// goto every Row of All the Cells 		
			
			//In a Row- Identifying the Number of Active Cells
			int rowOfCellsCount = row.getLastCellNum();
			
			for(int rowOfCellIndex=1;rowOfCellIndex<=rowOfCellsCount;rowOfCellIndex++) 		
			{ 			
				// creating a Row of a New Cell 	
				Cell newRowOfCell=row.createCell(rowOfCellIndex); 				 	
				By webTableXpathLocator=By.xpath(xpathExpressionPart1+rowIndex+xpathExpressionPart2+rowOfCellIndex+xpathExpressionPart3); 		
				WebElement WebTableXpath=driver.findElement(webTableXpathLocator); 				
				String data=WebTableXpath.getText(); 				 		
				// sending data to the Row of a Cell Created 			
				newRowOfCell.setCellValue(data); 				 	
				System.out.print(data+"   "); 				 		
			} 		
			System.out.println(); 	
			FileOutputStream fileOutPutStream = new FileOutputStream
					("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\WebTable.xlsx"); 
		workBook.write(fileOutPutStream); 	 	
		} 	 
	} 
	

}

