package pageobjects;

import org.openqa.selenium.WebDriver;

import selenium.Helper;
import testDataTypes.Customer;

public class APSignInPage {
	WebDriver driver;
	BaseClass baseClass;
	
	public APSignInPage(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}
	
	public String pageTitle = "Login - My Store";
	
	public String email = "//input[@id='email']";
	
	public String password = "//input[@id='passwd']";
	
	public String signIn = "//span[normalize-space() = 'Sign in']";
	
	public void verifySignInPageTitle()
	{
		Helper.verifyTitleContains(driver, pageTitle);
	}
	
	public void signInOperation(Customer customer)
	{
		baseClass.setTextByXpath(email, customer.emailAddress);;
		baseClass.setTextByXpath(password, customer.password);;
		baseClass.clickByXpath(signIn);
	}

}
