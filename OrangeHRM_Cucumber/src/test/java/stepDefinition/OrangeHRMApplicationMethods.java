package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods
{

	WebDriver driver;
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

@Given("^User should launch the Chrome Browser$")
public void user_should_launch_the_Chrome_Browser()
{
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\phani\\OneDrive\\Desktop\\Rajitha Testing\\OrangeHRM_Cucumber\\ChromeDriverFile\\chromedriver.exe");
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(applicationUrlAddress);
	
}

@When("^user enters the OrangeHRM Url Address$")
public void user_enters_the_OrangeHRM_Url_Address()
{
    
}

@Then("^User should be able to navigate to OrangeHRM Application LogIn Page$")
public void user_should_be_able_to_navigate_to_OrangeHRM_Application_LogIn_Page() 
{
    
}

@Then("^User should close the Browser and the Application$")
public void user_should_close_the_Browser_and_the_Application()
{
    
}


	
}
