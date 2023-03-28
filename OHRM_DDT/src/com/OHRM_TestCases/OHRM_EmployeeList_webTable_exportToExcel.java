package com.OHRM_TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.OHRM_BaseTest.BaseTest;
import com.Utility.Log;

public class OHRM_EmployeeList_webTable_exportToExcel extends BaseTest
{

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
				 ("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestDataFiles\\EmployeeList_WebTable.xlsx");
		 workBook = new XSSFWorkbook(logInTestDataFile);
		 sheet = workBook.getSheet("Sheet1");
		
		 propertyFile = new FileInputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\Config\\OrangeHRM.properties");
		 properties = new Properties();
		 properties.load(propertyFile);
		 
		Row row_expectedLogInPageTestData=sheet.getRow(1);
		Cell rowOfexpectedLogInPageTestDataCell=row_expectedLogInPageTestData.getCell(0);
		String expectedLogInPageTestData=rowOfexpectedLogInPageTestDataCell.getStringCellValue();
		System.out.println("The Expected LogIn Page Text is:-"+expectedLogInPageTestData);
		//Log.info("The Expected LogIn Page Text is:-"+expectedLogInPageTestData);
		
		By logInPageTextLocator=By.id(properties.getProperty("logInPageTextProperty"));
		WebElement LogInPageText=driver.findElement(logInPageTextLocator);
		String actualLogInPageText=LogInPageText.getText();
		System.out.println("The Actual LogIn Page Text is:-"+actualLogInPageText);
		//Log.info("The Actual LogIn Page Text is:-"+actualLogInPageText);
		
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
		
		
	    logInFileTestResultFile = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_EmployeeList_TestDataResultFile.xlsx");
		workBook.write(logInFileTestResultFile);
		
	}
	
	@Test(priority=2,description="Validating LogIn functionality")
	public void validatingLogInTest() throws IOException
	{
		
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(3);
		String userNameTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The UserName is :- "+userNameTestData);
		//Log.info(" The UserName is :- "+userNameTestData);
		
		testDataRowOfCell=testDataRow.getCell(4);
		String passwordTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Password is :- "+passwordTestData);
		//Log.info(" The Password is :- "+passwordTestData);
		
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
		System.out.println(" The Expected HomePage Text is :- "+expectedHomePageText);
		//Log.info(" The Expected HomePage Text is :- "+expectedHomePageText);
		
		By homePageTextLocator=By.id(properties.getProperty("homePageWelcomeAdminProperty"));
		homePageAdmin=driver.findElement(homePageTextLocator);
		String actualHomePageText=homePageAdmin.getText();
		System.out.println(" The Actual HomePage Text is :- "+actualHomePageText);
		//Log.info(" The Actual HomePage Text is :- "+actualHomePageText);
		
		Cell actualHomePageTextCell=testDataRow.createCell(6);
		actualHomePageTextCell.setCellValue(actualHomePageText);
		
		if(actualHomePageText.equals(expectedHomePageText))
		{
			System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
			//Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
			Cell resultHomePageTextCell=testDataRow.createCell(7);
			resultHomePageTextCell.setCellValue("Successfully Navigated to OrangeHRM Application HomePage - PASS");
		}
		else
		{
			System.out.println(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
			//Log.info(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
			Cell resultHomePageTextCell=testDataRow.createCell(7);
			resultHomePageTextCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		}

		logInFileTestResultFile= new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_EmployeeList_TestDataResultFile.xlsx");
		workBook.write(logInFileTestResultFile);
		

}
	
	@Test(priority=3,description="Validating HomePage PIM functionality ")
	public void pimTest()
	{
		By pimLocator=By.id(properties.getProperty("homePagePIM"));
		WebElement pim=driver.findElement(pimLocator);
		
		Actions pimAction = new Actions(driver);
		pimAction.moveToElement(pim).build().perform();
				
	}
	
	@Test(priority=4,description="Validating HomePage PIM_EmployeeList functionality") 
	public void employeeListTest() 
	{ 	
		By employeeListLocator=By.id(properties.getProperty("homePageEmployeeList")); 	
	    WebElement employeeList = driver.findElement(employeeListLocator);
	    employeeList.click(); 	
    } 
	
	@Test(priority=5,description="Validating - EmployeeList Page Text") 
	public void validatingAddEmployeePageText() throws IOException 
	
	{
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(8);
		String expectedEmployeeListPageText=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Expected HomePage Text is :- "+expectedEmployeeListPageText);
		
		By homePageEmployeeListTextLocator=By.id(properties.getProperty("homePageEmployeeList"));
		WebElement homePageEmployeeListText =driver.findElement(homePageEmployeeListTextLocator);
		String actualEmployeeListPageText=homePageEmployeeListText.getText();
		System.out.println(" The Actual HomePage Text is :- "+actualEmployeeListPageText);
		
		Cell actualEmployeeListPageTextCell=testDataRow.createCell(9);
		actualEmployeeListPageTextCell.setCellValue(actualEmployeeListPageText);
		if(actualEmployeeListPageText.equals(expectedEmployeeListPageText))
		{
			System.out.println("Successfully Validated EmployeeListPage Text - PASS");
			Cell resultEmployeeListPageTextCell=testDataRow.createCell(10);
			resultEmployeeListPageTextCell.setCellValue("Successfully Validated EmployeeListPage Text - PASS");
		}
		else
		{
			System.out.println("Failed to Validate EmployeeListPage Text - FAIL");
			Cell resultEmployeeListPageTextCell=testDataRow.createCell(10);
			resultEmployeeListPageTextCell.setCellValue("Failed to Validate EmployeeListPage Text - FAIL");
		}
		logInFileTestResultFile= new FileOutputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_EmployeeList_TestDataResultFile.xlsx");
		workBook.write(logInFileTestResultFile);
		
	}

	@Test(priority=6, description = "Export EmployeeList webtable Data to Excel")
	public void export_EmployeeListWebtable_toExcel() throws IOException
	{
		FileInputStream inputStreamFile = new FileInputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestDataFiles\\EmployeeListWebtableData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStreamFile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// /html/body/div[1]/div[3]/div[2]/div/form/div[4]/table
		
		By employeeListWebtableLocator = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table");
		WebElement employeeListWebtable = driver.findElement(employeeListWebtableLocator);
	
		//Identifying the Rows in the WebTable
	    List<WebElement>webTableRows = employeeListWebtable.findElements(By.tagName("tr"));
	     
	    System.out.println("The Number of Rows in a Webtable are:-"+webTableRows.size());
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
	    		
	    		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\EmployeeList_WebTableTestResults.xlsx");
	    		workbook.write(fileOutputStream);
	    	}
	    	System.out.println();
	   }

	}
}