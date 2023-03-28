package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_SingleTestData {
	
	public static void main(String[] args) throws IOException {
		
		//Identify the file in the system
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\SingleTestData.xlsx");
		
		//Identify the workbook in the file
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		
		//Identify the Sheet in the workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Identify the Row in the Sheet
		Row row = sheet.getRow(0);
		
		//Identify the Row of Cell
		Cell rowOfCell = row.getCell(0);
		
		String data = rowOfCell.getStringCellValue();
		System.out.println(data);
	}

}
