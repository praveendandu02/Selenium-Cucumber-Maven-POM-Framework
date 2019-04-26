package managers;

import org.openqa.selenium.WebDriver;

import pageobjects.APHomePage;
import pageobjects.APMyAccountPage;
import pageobjects.APOrderConfirmationPage;
import pageobjects.APOrderPage;
import pageobjects.APSignInPage;
import pageobjects.APTshirtsSectionPage;
import pageobjects.LoginPage;

public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private APHomePage homePage;
	private APMyAccountPage myAccountPage;
	private APOrderConfirmationPage orderConfirmationPage;
	private APOrderPage orderPage;
	private APSignInPage signInPage;
	private APTshirtsSectionPage tshirtsSectionPage;
	
	
	public PageObjectManager(WebDriver driver){
		this.driver = driver;
	}
	
	public APHomePage getAPHomePage(){
		return (homePage == null) ? homePage = new APHomePage(driver) : homePage;
	}
	
	public APMyAccountPage getAPMyAccountPage(){
		return (myAccountPage == null) ? myAccountPage = new APMyAccountPage(driver) : myAccountPage;
	}
	
	public APOrderConfirmationPage getAPOrderConfirmationPage(){
		return (orderConfirmationPage == null) ? orderConfirmationPage = new APOrderConfirmationPage(driver) : orderConfirmationPage;
	}
	
	public APOrderPage getAPOrderPage(){
		return (orderPage == null) ? orderPage = new APOrderPage(driver) : orderPage;
	}
	
	public APSignInPage getAPSignInPage(){
		return (signInPage == null) ? signInPage = new APSignInPage(driver) : signInPage;
	}
	
	public APTshirtsSectionPage getAPTshirtsSectionPage(){
		return (tshirtsSectionPage == null) ? tshirtsSectionPage = new APTshirtsSectionPage(driver) : tshirtsSectionPage;
	}
	
	public LoginPage getLoginPage(){
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

}
