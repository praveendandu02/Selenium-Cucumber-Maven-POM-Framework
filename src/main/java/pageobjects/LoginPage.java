package pageobjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import managers.FileReaderManager;
import selenium.Helper;
import testDataTypes.Customer;


public class LoginPage{
	WebDriver driver;
	BaseClass baseClass;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}
	
	final static Logger log = Logger.getLogger("LoginPage");
	
	public String username = "//input[@name='usernameOrEmail']";
	
	public String usernamecontinue_button = "//button[contains(text(),'Continue')]";
	
	public String password = "//input[@name='password']";
	
	public String login = "//button[contains(text(),'Log In')]";
		
	public String loginPageTitle = "Log In — WordPress.com";
	
	public String readerPageTitle = "Following ‹ Reader — WordPress.com";
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getWordPressApplicationUrl());
	}
	
	public void loginOperation(Customer customer)
	{
		typeUserName(customer.username);
		clickUserNameContinueButton();
		typePassword(customer.password);
	}
	
	public void verifyLoginPageTitle()
	{
		
		log.info("Login page title is verifying");
		Helper.verifyTitleContains(driver, loginPageTitle);
		Assert.assertEquals(baseClass.getTitle(), loginPageTitle);
		log.info("Login page title is verified");
	}
	
	public void verifyReaderPageTitle()
	{
		log.info("Reader page title is verifying");
		Helper.verifyTitleContains(driver, readerPageTitle);
		Assert.assertEquals(baseClass.getTitle(), readerPageTitle);
		log.info("Reader page title is verifying");
	}
	
	public void typeUserName(String uname)
	{
		log.info("Enter the username");
		baseClass.setTextByXpath(username,uname);
		log.info("Entered the username");
	}
	
	public void clickUserNameContinueButton()
	{
		log.info("Username continue button is clicking");
		baseClass.clickByXpath(usernamecontinue_button);
		log.info("Username continue button is clicked");
	}
	
	public void typePassword(String pword)
	{
		log.info("Enter the password");
		baseClass.setTextByXpath(password,pword);
		log.info("Entered the password");
	}
	
	public void clickLoginButton()
	{
		log.info("Login button is clicking");
		baseClass.clickByXpath(login);
		log.info("Login button is clicked");
	}

}
