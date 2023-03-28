package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write_TestData {
	
	public static void main(String[] args) throws IOException {
		
		
		//Identify the file in the System
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\SingleTestData.xlsx");
		
		//Identify the Workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		
		//Identify the Sheet in the Workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Create a Row in the sheet
		Row row = sheet.createRow(3);
		
		//Create a RowOFCell
		Cell rowOfCell= row.createCell(4);
		
		
		//Set the Value in the row Of Cell
		rowOfCell.setCellValue("Selenium");
		
		//Save the File with in the Workbook
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\SingleTestData.xlsx");
		workbook.write(fileOutputStream);
		
		
		
	}
	
	
	

}
