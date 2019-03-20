package pageobjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import selenium.Helper;

public class BaseClass {

	public static WebDriver driver;
	
	public BaseClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	final static Logger log = Logger.getLogger("BaseClass");
	
	
	
	public void clickByXpath(String xpath)
	{
		Helper.waitForWebElementUsingXPATH(driver, xpath, 20).click();
	
	}
	
	public String getTextByXpath(String xpath)
	{
		return Helper.waitForWebElementUsingXPATH(driver, xpath, 20).getText();
	}
	
	public boolean isDisplayed(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public String getTitle()
	{
		
		return driver.getTitle();
	}
	
	public void setTextByXpath(String xpath, String text)
	{
		Helper.waitForWebElementUsingXPATH(driver, xpath, 20).sendKeys(text);
	}
	
}
