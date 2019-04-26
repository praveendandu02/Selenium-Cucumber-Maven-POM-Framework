package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.APHomePage;
import pageobjects.LoginPage;

public class APHomePageSteps {
	TestContext testContext;
	APHomePage homePage;
	
	public APHomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getAPHomePage();
	}
	
	@Given("^I want to go to automationpractice website$")
	public void i_want_to_go_to_automationpractice_website() {
		
		homePage.navigateTo_ApHomePage();
		
	 }
	
	@Given("^verify the mystore title$")
	public void verify_the_mystore_title()  {
		
	    homePage.verifyAPHomePageTitle();
	}
	
	@When("^I click on sign in$")
	public void i_click_on_sign_in()  {
		
		homePage.navigateTo_LoginPage();
	    
	}

}
