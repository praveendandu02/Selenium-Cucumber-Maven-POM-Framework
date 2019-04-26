package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects.APOrderConfirmationPage;

public class APOrderConfirmationPageSteps {
	
	TestContext testContext;
	APOrderConfirmationPage orderConfirmationPage;
	
	public APOrderConfirmationPageSteps(TestContext context)
	{
		testContext = context;
		orderConfirmationPage = testContext.getPageObjectManager().getAPOrderConfirmationPage();
	}
	
	@Then("^I should see order confirmation page$")
	public void i_should_see_order_confirmation_page() {
	    orderConfirmationPage.verifyOrderConfirmationPageTitle();
	}
	
	@Then("^validate the payment amount$")
	public void validate_the_payment_amount() {
		orderConfirmationPage.verifyPaymentAmount();
	    
	}
	

}
