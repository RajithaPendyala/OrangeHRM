package com.OHRM_TestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.OHRM_BaseTest.BaseTest;

public class OHRM_LogInFunctionality_MultipleTestData extends BaseTest 
{

	FileInputStream logInTestDataFile;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
    WebElement homePageAdmin;
	
	FileOutputStream logInFileTestResultFile;
	FileInputStream propertyFile;
	Properties properties;
	
	
	
	@Test(priority=1,description="Validating LogInPage Test")
	public void validatingOrangeHRMApplicationLogInPageTest() throws IOException
	{
		 logInTestDataFile = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestDataFiles\\LogInTestmultipleTestData.xlsx");
		 workBook = new XSSFWorkbook(logInTestDataFile);
		 sheet = workBook.getSheet("Sheet1");
		 
		 propertyFile = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\Config\\OrangeHRM.properties");
		 properties = new Properties();
		 properties.load(propertyFile);
		
		Row row_expectedLogInPageTestData=sheet.getRow(1);
		Cell rowOfexpectedLogInPageTestDataCell=row_expectedLogInPageTestData.getCell(0);
		String expectedLogInPageTestData=rowOfexpectedLogInPageTestDataCell.getStringCellValue();
		
		By logInPageTextLocator=By.id(properties.getProperty("logInPageTextProperty"));
		WebElement LogInPageText=driver.findElement(logInPageTextLocator);
		String actualLogInPageText=LogInPageText.getText();
		
		Cell actualLogInPageTextNewCell=row_expectedLogInPageTestData.createCell(1);
		actualLogInPageTextNewCell.setCellValue(actualLogInPageText);
		
		if(actualLogInPageText.equals(expectedLogInPageTestData))
		{
			System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
			Cell rowResult_LogInPageTextCell=row_expectedLogInPageTestData.createCell(2);
			rowResult_LogInPageTextCell.setCellValue("Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
		
		}
		else
		{
			System.out.println(" Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			Cell rowResult_LogInPageTextCell=row_expectedLogInPageTestData.createCell(2);
			rowResult_LogInPageTextCell.setCellValue("Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		}
		
		
	    logInFileTestResultFile = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_LogInTest_MultipleTestDataResultFile.xlsx");
		workBook.write(logInFileTestResultFile);
		
	}
	
	@Test(priority=2,description="Validating LogIn functionality")
	public void validatingLogInTest() throws IOException
	{
		int rowsCount = sheet.getLastRowNum();
		for(int rowIndex =1;rowIndex<=rowsCount;rowIndex++ )
		{
			Row testDataRow=sheet.getRow(rowIndex);
			Cell testDataRowOfCell=testDataRow.getCell(3);
			String userNameTestData=testDataRowOfCell.getStringCellValue();
			System.out.println(" The UserName is :- "+userNameTestData);
			
			testDataRowOfCell=testDataRow.getCell(4);
			String passwordTestData=testDataRowOfCell.getStringCellValue();
			System.out.println(" The Password is :- "+passwordTestData);
			

			By userNameLocator=By.id(properties.getProperty("userNameProperty"));
			WebElement userName=driver.findElement(userNameLocator);
			userName.sendKeys(userNameTestData);
			
			By passwordLocator=By.name(properties.getProperty("passwordProperty"));
			WebElement password=driver.findElement(passwordLocator);
			password.sendKeys(passwordTestData);
			
			By logInButtonLocator=By.className(properties.getProperty("logInPageLogInButton"));
			WebElement logInButton=driver.findElement(logInButtonLocator);
			logInButton.click();
			
		   // String actualUrl =   driver.getCurrentUrl();
		   // String expectedUrl = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
			
			testDataRowOfCell=testDataRow.getCell(5);
			String expectedHomePageUrl=testDataRowOfCell.getStringCellValue();
			System.out.println(" The Expected HomePage Url is :- "+expectedHomePageUrl);
			
			String actualHomePageUrl = driver.getCurrentUrl();
			System.out.println(" The Actual HomePage Url is :- "+actualHomePageUrl);
			Cell actualHomePageTextCell=testDataRow.createCell(6);
			actualHomePageTextCell.setCellValue(actualHomePageUrl);
			
			
		    if(actualHomePageUrl.equals(expectedHomePageUrl))
		    {
		     System.out.println("LogIn Successful and ORHM Apllication Navigated to Homepage- PASS");
		     Cell resultHomePageTextCell=testDataRow.createCell(7);
		   	 resultHomePageTextCell.setCellValue("LogIn Successful and ORHM Apllication Navigated to Homepage- PASS");
		    }
		    else
		    {
		    	System.out.println("Login failed and ORHM Failed to Navigate to Homepage- FAIL");
		    	Cell resultHomePageTextCell=testDataRow.createCell(7);
				resultHomePageTextCell.setCellValue("Login failed and ORHM Failed to Navigate to Homepage- FAIL");
		    }
		    logInFileTestResultFile= new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_LogInTest_MultipleTestDataResultFile.xlsx");
			workBook.write(logInFileTestResultFile);
			
		    
		}
		
  }
	
}

