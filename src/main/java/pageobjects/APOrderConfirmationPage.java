package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import selenium.Helper;

public class APOrderConfirmationPage {
	WebDriver driver;
	BaseClass baseClass;
	
	public APOrderConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	public String pageTitle = "Order confirmation - My Store";
	
	public String paymentAmount = "//strong[contains(text(),'$18.51')]";
	
	public void verifyOrderConfirmationPageTitle()
	{
		Helper.verifyTitleContains(driver, pageTitle);
	}
	
	public String getPaymentAmount()
	{
		return driver.findElement(By.xpath(paymentAmount)).getText();
	}
	
	public void verifyPaymentAmount()
	{
		Assert.assertEquals(getPaymentAmount(),"$18.51");
	}
}
