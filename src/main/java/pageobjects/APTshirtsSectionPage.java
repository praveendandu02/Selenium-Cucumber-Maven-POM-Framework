package pageobjects;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import selenium.Helper;

public class APTshirtsSectionPage {
	WebDriver driver;
	BaseClass baseClass;
	
	public APTshirtsSectionPage(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}
	
	public String tshirtMediumSize = "//a[contains(text(),'M')]";
	
	public String pageTitle = "T-shirts - My Store";
	
	public String mouseoverFadedTshirt = "//a/img[@title='Faded Short Sleeve T-shirts']";
	
	public String addToCart = "//span[contains(text(),'Add to cart')]";
	
	public String proceedToCheckout = "//*[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]";
	
	public void verifyTshirtsPageTitle()
	{
		Helper.verifyTitleContains(driver, pageTitle);
	}
	
	public void chooseMediumSize()
	{
		baseClass.clickByXpath(tshirtMediumSize);
	}
	
	public void addFadedTshirtToCart()
	{
		baseClass.mouseOver(mouseoverFadedTshirt);
		baseClass.clickByXpath(addToCart);
	}
	
	public void selectProceedToCheckout()
	{
		baseClass.clickByXpath(proceedToCheckout);
	}

}
