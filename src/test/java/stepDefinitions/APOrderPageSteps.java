package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.APOrderPage;

public class APOrderPageSteps {
	
	TestContext testContext;
	APOrderPage orderPage;
	
	public APOrderPageSteps(TestContext context)
	{
		testContext = context;
		orderPage = testContext.getPageObjectManager().getAPOrderPage();
	}
	
	@Then("^I should see my order page$")
	public void i_should_see_my_order_page() {
		
		orderPage.verifyOrderPageTitle();
	}
	
	@When("^I choose proceed to checkout on order page$")
	public void i_choose_proceed_to_checkout_on_order_page() {
		
		orderPage.selectProceedToCheckOut();
		orderPage.selectProceedToCheckOut();
		orderPage.agreeTermsAndConditions();
		orderPage.selectProceedToCheckOut();
	    
	}
	
	@When("^I choose the payment method cheque$")
	public void i_choose_the_payment_method_cheque() {
	    orderPage.selectPayByCheckMethod();
	}
	
	@When("^I confirm my order$")
	public void i_confirm_my_order() throws Throwable {
	    orderPage.selectConfirmMyOrder();
	}

}
