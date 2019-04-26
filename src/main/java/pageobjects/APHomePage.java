package pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import managers.FileReaderManager;
import selenium.Helper;

public class APHomePage {
	WebDriver driver;
	BaseClass baseClass;
	
	public APHomePage(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}
	
	public String pageTitle = "My Store";
	
	public String signIn = "//a[normalize-space() = 'Sign in']";
	
	public void navigateTo_ApHomePage()
	{
		driver.get(FileReaderManager.getInstance().getConfigReader().getAPApplicationUrl());
	}
	
	public void verifyAPHomePageTitle()
	{
		
		Helper.verifyTitleContains(driver, pageTitle);
		
	}
	
	public void navigateTo_LoginPage()
	{
		baseClass.clickByXpath(signIn);
	}

}
