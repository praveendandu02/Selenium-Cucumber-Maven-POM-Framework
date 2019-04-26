package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.Helper;

public class APOrderPage {
	WebDriver driver;
	BaseClass baseClass;
	
	public APOrderPage(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}
	
	public String pageTitle = "Order - My Store";
	
	public String proceedToCheckout = "//*[@id='center_column']//span[contains(text(),'Proceed to checkout')]";
	
	public String readTheTerms = "//label[contains(text(),'I agree to the terms of service and will adhere to them unconditionally.')]";
	
	public String payByCheck = "//a[contains(text(),'Pay by check ')]";
	
	public String confirmOrder = "//span[contains(text(),'I confirm my order')]";
	
	public void verifyOrderPageTitle()
	{
		Helper.verifyTitleContains(driver, pageTitle);
	}
	
	public void selectProceedToCheckOut()
	{
		//WebElement body = driver.findElement(By.cssSelector("body"));
		//body.sendKeys(Keys.PAGE_DOWN);
		baseClass.clickByXpath(proceedToCheckout);
	}
	
	public void agreeTermsAndConditions()
	{
		baseClass.clickByXpath(readTheTerms);
	}
	
	public void selectPayByCheckMethod()
	{
		baseClass.clickByXpath(payByCheck);
	}
	
	public void selectConfirmMyOrder()
	{
		baseClass.clickByXpath(confirmOrder);
	}

}
