package com.TestNGWebTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_ExportFirstColumnDataToExcel extends BaseTest
{

	@Test(priority=1,description = "Exporting WebTable First Column to Excel")
	public void ExportFirstColumnDataToExcel() throws InterruptedException, IOException
	{
		
		String xpathExpression1 ="/html/body/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String xpathExpression2 = "]/td[1]";
		
		
		FileInputStream excelFileInputStream = new FileInputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\WebTable.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[2]/td[1]
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[3]/td[1]
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[4]/td[1]
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
		
		// /html/body/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		// /html/body/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]

		Thread.sleep(5000);
		// //*[@id="qc-cmp2-ui"]/div[2]/div/button[2]
		driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
		//Thread.sleep(10000);
		
		for(int index=1; index<=36;index++)
		{
			Row row = sheet.createRow(index);
			Cell newRowOfCell = row.createCell(0);
			By cityNameExpressionLocator = By.xpath
		(xpathExpression1+index+xpathExpression2);
			WebElement cityNameExpression = driver.findElement(cityNameExpressionLocator);
			
			String cityName = cityNameExpression.getText();
			System.out.println(cityName);
			newRowOfCell.setCellValue(cityName);
			FileOutputStream fileOutputStream = new FileOutputStream
					("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\WebTesting\\src\\com\\ExcelTestDataFiles\\WebTable.xlsx");
			workbook.write(fileOutputStream);
		
	    }
	}
}