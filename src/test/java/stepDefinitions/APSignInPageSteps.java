package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageobjects.APSignInPage;
import testDataTypes.Customer;

public class APSignInPageSteps {
	TestContext testContext;
	APSignInPage signInPage;
	
	public APSignInPageSteps(TestContext context) {
		testContext = context;
		signInPage = testContext.getPageObjectManager().getAPSignInPage();
	}
	
	@Then("^I should see the login page$")
	public void i_should_see_the_login_page() {
		
		signInPage.verifySignInPageTitle();
	    
	}
	
	@When("^I enter \"([^\"]*)\" login credentials$")
	public void i_enter_login_credentials(String customerName) {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);	
		signInPage.signInOperation(customer);
	}

}
