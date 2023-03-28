package com.OHRM_TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import com.Utility.Log;

public class OHRM_LogInTest extends BaseTest {
	
	FileInputStream logInTestDataFile;
	FileInputStream propertyFile;
	Properties properties;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
    WebElement homePageAdmin;
	
	FileOutputStream logInFileTestResultFile;
	
	
	
	@Test(priority=1,description="Validating LogInPage Test")
	public void validatingOrangeHRMApplicationLogInPageTest() throws IOException
	{
		 logInTestDataFile = new FileInputStream
				 ("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestDataFiles\\LogInTestSingleTestData.xlsx");
		 workBook = new XSSFWorkbook(logInTestDataFile);
		 sheet = workBook.getSheet("Sheet1");
		
		 propertyFile = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\Config\\OrangeHRM.properties");
		 properties = new Properties();
		 properties.load(propertyFile);
		 
		Row row_expectedLogInPageTestData=sheet.getRow(1);
		Cell rowOfexpectedLogInPageTestDataCell=row_expectedLogInPageTestData.getCell(0);
		String expectedLogInPageTestData=rowOfexpectedLogInPageTestDataCell.getStringCellValue();
		//System.out.println("The Expected LogIn Page Text is:-"+expectedLogInPageTestData);
		Log.info("The Expected LogIn Page Text is:-"+expectedLogInPageTestData);
		
		By logInPageTextLocator=By.id(properties.getProperty("logInPageTextProperty"));
		WebElement LogInPageText=driver.findElement(logInPageTextLocator);
		String actualLogInPageText=LogInPageText.getText();
		//System.out.println("The Actual LogIn Page Text is:-"+actualLogInPageText);
		Log.info("The Actual LogIn Page Text is:-"+actualLogInPageText);
		
		Cell actualLogInPageTextNewCell=row_expectedLogInPageTestData.createCell(1);
		actualLogInPageTextNewCell.setCellValue(actualLogInPageText);
		
		if(actualLogInPageText.equals(expectedLogInPageTestData))
		{
			//System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
			Log.info("Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
			Cell rowResult_LogInPageTextCell=row_expectedLogInPageTestData.createCell(2);
			rowResult_LogInPageTextCell.setCellValue("Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
		
		}
		else
		{
			//System.out.println(" Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			Log.info(" Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			Cell rowResult_LogInPageTextCell=row_expectedLogInPageTestData.createCell(2);
			rowResult_LogInPageTextCell.setCellValue("Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		}
		
		
	    logInFileTestResultFile = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_LogInTest_SingleTestDataResultFile.xlsx");
		workBook.write(logInFileTestResultFile);
		
	}
	
	@Test(priority=2,description="Validating LogIn functionality")
	public void validatingLogInTest() throws IOException
	{
		
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(3);
		String userNameTestData=testDataRowOfCell.getStringCellValue();
		//System.out.println(" The UserName is :- "+userNameTestData);
		Log.info(" The UserName is :- "+userNameTestData);
		
		testDataRowOfCell=testDataRow.getCell(4);
		String passwordTestData=testDataRowOfCell.getStringCellValue();
		//System.out.println(" The Password is :- "+passwordTestData);
		Log.info(" The Password is :- "+passwordTestData);
		
		By userNameLocator=By.id(properties.getProperty("userNameProperty"));
		WebElement userName=driver.findElement(userNameLocator);
		userName.sendKeys(userNameTestData);
		
		By passwordLocator=By.name(properties.getProperty("passwordProperty"));
		WebElement password=driver.findElement(passwordLocator);
		password.sendKeys(passwordTestData);
		
		By logInButtonLocator=By.className(properties.getProperty("logInPageLogInButton"));
		WebElement logInButton=driver.findElement(logInButtonLocator);
		logInButton.click();
		
		testDataRowOfCell=testDataRow.getCell(5);
		String expectedHomePageText=testDataRowOfCell.getStringCellValue();
		//System.out.println(" The Expected HomePage Text is :- "+expectedHomePageText);
		Log.info(" The Expected HomePage Text is :- "+expectedHomePageText);
		
		By homePageTextLocator=By.id(properties.getProperty("homePageWelcomeAdminProperty"));
		homePageAdmin=driver.findElement(homePageTextLocator);
		String actualHomePageText=homePageAdmin.getText();
		//System.out.println(" The Actual HomePage Text is :- "+actualHomePageText);
		Log.info(" The Actual HomePage Text is :- "+actualHomePageText);
		
		Cell actualHomePageTextCell=testDataRow.createCell(6);
		actualHomePageTextCell.setCellValue(actualHomePageText);
		
		if(actualHomePageText.equals(expectedHomePageText))
		{
			//System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
			Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
			Cell resultHomePageTextCell=testDataRow.createCell(7);
			resultHomePageTextCell.setCellValue("Successfully Navigated to OrangeHRM Application HomePage - PASS");
		}
		else
		{
			//System.out.println(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
			Log.info(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
			Cell resultHomePageTextCell=testDataRow.createCell(7);
			resultHomePageTextCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		}

		logInFileTestResultFile= new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_LogInTest_SingleTestDataResultFile.xlsx");
		workBook.write(logInFileTestResultFile);
		

}
	
	@Test(priority=3,description="Validating LogOut Test")
	public void logOutTest() throws InterruptedException
	{
		homePageAdmin.click();
		
		// Thread.sleep(10000); // Java Wait
						
		By logOutLocator=By.linkText(properties.getProperty("homePageLogOutProperty"));
		
		// Explicit wait
	//	WebDriverWait logOutwait = new WebDriverWait(driver, 7);
	//	logOutwait.until(ExpectedConditions.visibilityOfElementLocated(logOutLocator));
				
		WebElement logOut=driver.findElement(logOutLocator);
		logOut.click();
		//System.out.println("OrangeHRM Application LogOut Successful");
		Log.info("OrangeHRM Application LogOut Successful");
	}

}