package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Multiple_TestData {
	
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream file = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\MultipleTestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// To find the Number of Active Rows
		int rowsCount = sheet.getLastRowNum();
		
		//To go to all Active Rows
		for(int rowIndex=0; rowIndex<=rowsCount;rowIndex++)
		{
			//To go to An Active Row
			Row row = sheet.getRow(rowIndex);
			
			//In the Active Row- find the Number of Active Cells
			int rowOfCellCount = row.getLastCellNum();
			
			//To go to Every Active Row of all the Active Cells
			for(int rowOfCellIndex = 0;rowOfCellIndex<rowOfCellCount;rowOfCellIndex++ )
			{
				//Go to the Row of Cell
				Cell rowOfCell = row.getCell(rowOfCellIndex);
				
				//Get the data from Row of Cell
				String data = rowOfCell.getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
		
	}

}
