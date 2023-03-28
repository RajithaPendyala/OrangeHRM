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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.OHRM_BaseTest.BaseTest;

public class OHRM_AddEmployee extends BaseTest 
{
	FileInputStream logInTestDataFile;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
    WebElement homePageAdmin;
	
	FileOutputStream logInFileTestResultFile;
	FileInputStream propertyFile;
	Properties properties;
	String firstNameTestData;
	String middleNameTestData;
	String lastNameTestData;
	String EmployeeIdValue;
	
	
	
	@Test(priority=1,description="Validating LogInPage Test")
	public void validatingOrangeHRMApplicationLogInPageTest() throws IOException
	{
		 logInTestDataFile = new FileInputStream
		 ("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestDataFiles\\AddEmployeeTest.xlsx");
		 workBook = new XSSFWorkbook(logInTestDataFile);
		 sheet = workBook.getSheet("Sheet1");
		 
		 propertyFile = new FileInputStream
				 ("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\Config\\OrangeHRM.properties");
		 properties = new Properties();
		 properties.load(propertyFile);
		
		Row row_expectedLogInPageTestData=sheet.getRow(1);
		Cell rowOfexpectedLogInPageTestDataCell=row_expectedLogInPageTestData.getCell(0);
		String expectedLogInPageTestData=rowOfexpectedLogInPageTestDataCell.getStringCellValue();
		System.out.println("The Expected Text of OrangeHRM LogIn Page is:- "+expectedLogInPageTestData);
		
		By logInPageTextLocator=By.id(properties.getProperty("logInPageTextProperty"));
		WebElement LogInPageText=driver.findElement(logInPageTextLocator);
		String actualLogInPageText=LogInPageText.getText();
		System.out.println("The Actual Text of OrangeHRM LogIn Page is:- "+actualLogInPageText);
		
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
		
				
	    logInFileTestResultFile = new FileOutputStream
	    		("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_AddEmployee_TestDataResultsFile.xlsx");
		workBook.write(logInFileTestResultFile);
		
	}
	
	@Test(priority = 2, description = "Validating OrangeHRM Login Page Title")
	public void validating_OrangeHRM_LoginPageTitle() throws IOException
	{
		
		
		Row row_LogInPageTitleTestData=sheet.getRow(1);
		Cell rowOfexpectedLogInPageTitleTestDataCell=row_LogInPageTitleTestData.getCell(3);
		String expectedLogInPageTitle=rowOfexpectedLogInPageTitleTestDataCell.getStringCellValue();
		System.out.println("The Expected LogIn Page Title is-"+expectedLogInPageTitle);
		
		
		String actualLogInPageTitle=driver.getTitle();
		System.out.println("The Actual LogIn Page Title is-"+actualLogInPageTitle);
		
		
		Cell actualLogInPageTextTitleNewCell=row_LogInPageTitleTestData.createCell(4);
		actualLogInPageTextTitleNewCell.setCellValue(actualLogInPageTitle);
		
		if(actualLogInPageTitle.equals(expectedLogInPageTitle))
		{
			System.out.println(" Successfully Validated OrangeHRM Application LogIn Page Title - PASS");
			Cell rowResult_LogInPageTextCell=row_LogInPageTitleTestData.createCell(5);
			rowResult_LogInPageTextCell.setCellValue("Successfully Validated OrangeHRM Application LogIn Page Title - PASS");
		
		}
		else
		{
			System.out.println(" Failed to Validate OrangeHRM Application LogIn Page Title - FAIL");
			Cell rowResult_LogInPageTextCell=row_LogInPageTitleTestData.createCell(5);
			rowResult_LogInPageTextCell.setCellValue("Failed to Validate OrangeHRM Application LogIn Page Title - FAIL");
		}
		
				
	    logInFileTestResultFile = new FileOutputStream("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_AddEmployee_TestDataResultsFile.xlsx");
		workBook.write(logInFileTestResultFile);
	}
	@Test(priority=3,description="Validating LogIn functionality")
	public void validatingLogInTest() throws IOException
	{
		
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(6);
		String userNameTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The UserName is :- "+userNameTestData);
		
		testDataRowOfCell=testDataRow.getCell(7);
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
		
		testDataRowOfCell=testDataRow.getCell(8);
		String expectedHomePageText=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Expected HomePage Text is :- "+expectedHomePageText);
		
		By homePageTextLocator=By.id(properties.getProperty("homePageWelcomeAdminProperty"));
		homePageAdmin=driver.findElement(homePageTextLocator);
		String actualHomePageText=homePageAdmin.getText();
		System.out.println(" The Actual HomePage Text is :- "+actualHomePageText);
		
		Cell actualHomePageTextCell=testDataRow.createCell(9);
		actualHomePageTextCell.setCellValue(actualHomePageText);
		
		if(actualHomePageText.equals(expectedHomePageText))
		{
			System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
			Cell resultHomePageTextCell=testDataRow.createCell(10);
			resultHomePageTextCell.setCellValue("Successfully Navigated to OrangeHRM Application HomePage - PASS");
		}
		else
		{
			System.out.println(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
			Cell resultHomePageTextCell=testDataRow.createCell(10);
			resultHomePageTextCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		}

		logInFileTestResultFile= new FileOutputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_AddEmployee_TestDataResultsFile.xlsx");
		workBook.write(logInFileTestResultFile);
		

  }

	@Test(priority=4,description="Validating HomePage PIM functionality ")
	public void pimTest()
	{
		By pimLocator=By.id(properties.getProperty("homePagePIM"));
		WebElement pim=driver.findElement(pimLocator);
		
		Actions pimAction = new Actions(driver);
		pimAction.moveToElement(pim).build().perform();
				
	}
	
	@Test(priority=5,description="Validating HomePage PIM_AddEmployee functionality") 
	public void addEmployeeTest() 
	{ 	
		By addEmployeeLocator=By.id(properties.getProperty("homePageAddEmpoyee")); 	
	    WebElement addEmployee=driver.findElement(addEmployeeLocator);
	    addEmployee.click(); 	
   } 
	
	@Test(priority=6,description="Validating - AddEmployee Page Text") 
	public void validatingAddEmployeePageText() throws IOException 
	
	{
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(11);
		String expectedAddEmployeePageText=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Expected HomePage Text is :- "+expectedAddEmployeePageText);
		
		By homePageAddEmployeeTextLocator=By.id(properties.getProperty("homePageAddEmpoyee"));
		WebElement homePageAddEmployeeText =driver.findElement(homePageAddEmployeeTextLocator);
		String actualAddEmployeePageText=homePageAddEmployeeText.getText();
		System.out.println(" The Actual HomePage Text is :- "+actualAddEmployeePageText);
		
		Cell actualAddEmployeePageTextCell=testDataRow.createCell(12);
		actualAddEmployeePageTextCell.setCellValue(actualAddEmployeePageText);
		if(actualAddEmployeePageText.equals(expectedAddEmployeePageText))
		{
			System.out.println("Successfully Validated AddEmployeePage Text - PASS");
			Cell resultAddEmployeePageTextCell=testDataRow.createCell(13);
			resultAddEmployeePageTextCell.setCellValue("Successfully Validated AddEmployeePage Text - PASS");
		}
		else
		{
			System.out.println("Failed to Validate AddEmployeePage Text - FAIL");
			Cell resultAddEmployeePageTextCell=testDataRow.createCell(13);
			resultAddEmployeePageTextCell.setCellValue("Failed to Validate AddEmployeePage Text - FAIL");
		}
		logInFileTestResultFile= new FileOutputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_AddEmployee_TestDataResultsFile.xlsx");
		workBook.write(logInFileTestResultFile);
		
	}
	
	@Test(priority=7, description = "Create New Employee To OrangeHRM Application")
	public void createNewEmployee() throws IOException, InterruptedException
	{
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(14);
	    firstNameTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Employee FirstName is :- "+firstNameTestData);
		
		testDataRowOfCell=testDataRow.getCell(15);
		middleNameTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Employee MiddleName is :- "+middleNameTestData);
		
		testDataRowOfCell=testDataRow.getCell(16);
		lastNameTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Employee LastName is :- "+lastNameTestData);
		
		By firstNameLocator=By.id(properties.getProperty("addEmployeeFirstName"));
		WebElement firstName=driver.findElement(firstNameLocator);
		firstName.sendKeys(firstNameTestData);
		
		By middleNameLocator=By.name(properties.getProperty("addEmployeeMiddleName"));
		WebElement middleName=driver.findElement(middleNameLocator);
		middleName.sendKeys(middleNameTestData);
		
		By lastNameLocator=By.name(properties.getProperty("addEmployeeLastName"));
		WebElement lastName=driver.findElement(lastNameLocator);
		lastName.sendKeys(lastNameTestData);
		
		By employeeIdLocator= By.id(properties.getProperty("addEmployeeEmployeeId"));
	    WebElement employeeID = driver.findElement(employeeIdLocator);
	    EmployeeIdValue = employeeID.getAttribute("Value");
	    System.out.println("The New Employee Id from AddEmployee Page is:-"+EmployeeIdValue);
	    Cell employeeIdTextCell=testDataRow.createCell(17);
	    employeeIdTextCell.setCellValue(EmployeeIdValue);
	    
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.TAB).build().perform();
	    action.sendKeys(Keys.TAB).build().perform();
	    action.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(5000);
	    java.lang.Runtime.getRuntime().exec("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\OHRMAutoItScripts\\EmployeePhotograph.exe");
	    Thread.sleep(5000);
	    
	    
	    
	    logInFileTestResultFile= new FileOutputStream
				("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_AddEmployee_TestDataResultsFile.xlsx");
		workBook.write(logInFileTestResultFile);
	    
	    By saveButtonLocator=By.id(properties.getProperty("addEmployeePageSaveButton"));
		WebElement saveButton=driver.findElement(saveButtonLocator);
		saveButton.click();
	}
	
	/*
	
	@Test(priority=8, description = "Validating PersonalDetails Page")
	public void validatingPersonalDetailsPage() throws IOException
	{
		Row testDataRow=sheet.getRow(1);
		Cell testDataRowOfCell=testDataRow.getCell(18);
		String expected_PersonalDetailsPageTestData=testDataRowOfCell.getStringCellValue();
		System.out.println(" The Expected Personal Details Page Text is :- "+expected_PersonalDetailsPageTestData);
		
		By personalDetailsPageTextLocator=By.linkText(properties.getProperty("personalDetailsPageText"));
		WebElement personalDetailsPageText=driver.findElement(personalDetailsPageTextLocator);
		String actual_PersonalDetailsPageText=personalDetailsPageText.getText();
		System.out.println("The ActualTitle of Personal Details Page is :-"+actual_PersonalDetailsPageText);
		Cell actual_PersonalDetailsPageTextCell=testDataRow.createCell(19);
		actual_PersonalDetailsPageTextCell.setCellValue(actual_PersonalDetailsPageText);
		
		if(actual_PersonalDetailsPageText.equals(expected_PersonalDetailsPageTestData))
		{
			System.out.println("Successfully Validated PersonalDetailsPage Text - PASS");
			Cell resultAddEmployeePageTextCell=testDataRow.createCell(20);
			resultAddEmployeePageTextCell.setCellValue("Successfully Validated PersonalDetailsPage Text - PASS");
		}
		else
		{
			System.out.println("Failed to Validate PersonalDetailsPage Text - FAIL");
			Cell resultAddEmployeePageTextCell=testDataRow.createCell(20);
			resultAddEmployeePageTextCell.setCellValue("Failed to Validate AddEmployeePage Text - FAIL");
		}
		
		//Validating FirstName Value
		By firstNameLocator= By.id(properties.getProperty("personalDetailsPageFirstName"));
	    WebElement personalDetailsFirstName = driver.findElement(firstNameLocator);
	    String actual_firstNameValue = personalDetailsFirstName.getAttribute("Value");
	    System.out.println("The Actual FirstName of Personal Details Page is:-"+actual_firstNameValue);
	    Cell actualFirstNameCell=testDataRow.createCell(21);
	    actualFirstNameCell.setCellValue(actual_firstNameValue);
	    if(actual_firstNameValue.equals(firstNameTestData))
	    {
	    	System.out.println("Successfully Validated FirstName Value - PASS");
			Cell resultFirstNameCell=testDataRow.createCell(22);
			resultFirstNameCell.setCellValue("Successfully Validated FirstName Value - PASS");
	    }
	    else
	    {
	    	System.out.println("Failed to Validate FirstName Value - FAIL");
			Cell resultFirstNameCell=testDataRow.createCell(22);
			resultFirstNameCell.setCellValue("Failed to Validate FirstName Value - FAIL");
	    }
	    
		//Validating MiddleName Value
		By MiddleNameLocator= By.id(properties.getProperty("personalDetailsPageMiddleName"));
	    WebElement personalDetailsMiddleName = driver.findElement(MiddleNameLocator);
	    String actual_MiddleNameValue = personalDetailsMiddleName.getAttribute("Value");
	    System.out.println("The Actual MiddleName of Personal Details Page is:-"+actual_MiddleNameValue);
	    Cell actualMiddleNameCell=testDataRow.createCell(23);
	    actualMiddleNameCell.setCellValue(actual_MiddleNameValue);
	    if(actual_MiddleNameValue.equals(middleNameTestData))
	    {
	    	System.out.println("Successfully Validated MiddleName Value - PASS");
			Cell resultMiddleNameCell=testDataRow.createCell(24);
			resultMiddleNameCell.setCellValue("Successfully Validated MiddleName Value - PASS");
	    }
	    else
	    {
	    	System.out.println("Failed to Validate FirstName Value - FAIL");
			Cell resultMiddleNameCell=testDataRow.createCell(24);
			resultMiddleNameCell.setCellValue("Failed to Validate MiddleName Value - FAIL");
	    }
	    
				
		//Validating LastName Value
		By lastNameLocator= By.id(properties.getProperty("personalDetailsPageLastName"));
	    WebElement personalDetailsLastName = driver.findElement(lastNameLocator);
	    String actual_LastNameValue = personalDetailsLastName.getAttribute("Value");
	    System.out.println("The Actual LastName of Personal Details Page is:-"+actual_LastNameValue);
	    Cell actualLastNameCell=testDataRow.createCell(25);
	    actualLastNameCell.setCellValue(actual_LastNameValue);
	    if(actual_LastNameValue.equals(lastNameTestData))
	    {
	    	System.out.println("Successfully Validated LastName Value - PASS");
			Cell resultLastNameCell=testDataRow.createCell(26);
			resultLastNameCell.setCellValue("Successfully Validated LastName Value - PASS");
	    }
	    else
	    {
	    	System.out.println("Failed to Validate FirstName Value - FAIL");
			Cell resultLastNameCell=testDataRow.createCell(26);
			resultLastNameCell.setCellValue("Failed to Validate LastName Value - FAIL");
	    }
	    
		//Validating EmployyeId Value
		By personalDetailsEmployeeIdLocator= By.id(properties.getProperty("personalDetailsPageEmployeeId"));
	    WebElement personalDetailsEmployeeId = driver.findElement(personalDetailsEmployeeIdLocator);
	    String pdEmployeeIdValue = personalDetailsEmployeeId.getAttribute("Value");
	    System.out.println("The Actual EmployeeId of Personal Details Page is:-"+pdEmployeeIdValue);
	    Cell employeeIdCell=testDataRow.createCell(27);
	    employeeIdCell.setCellValue(pdEmployeeIdValue);
	    if(pdEmployeeIdValue.equals(EmployeeIdValue))
	    {
		   	System.out.println("Successfully Validated EmployeeId Value - PASS");
			Cell resultLastNameCell=testDataRow.createCell(28);
			resultLastNameCell.setCellValue("Successfully Validated EmployeeId Value - PASS");
	    }
	    else
	    {
	    	System.out.println("Failed to Validate EmployeeId Value - FAIL");
			Cell resultLastNameCell=testDataRow.createCell(28);
			resultLastNameCell.setCellValue("Failed to Validate EmployeeId Value - FAIL");
	    }
	    logInFileTestResultFile= new FileOutputStream
								("C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OHRM_DDT\\src\\com\\OHRM_ApplicationTestResultFiles\\OHRM_AddEmployee_TestDataResultsFile.xlsx");
		workBook.write(logInFileTestResultFile);
	}
	
	@Test(priority=9,description="Validating LogOut Test")
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
    }
    */
}

