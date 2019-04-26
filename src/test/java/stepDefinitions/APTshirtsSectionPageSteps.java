package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.APTshirtsSectionPage;

public class APTshirtsSectionPageSteps {
	TestContext testContext;
	APTshirtsSectionPage tshirtsSectionPage;
	
	public APTshirtsSectionPageSteps(TestContext context) {
		testContext = context;
		tshirtsSectionPage = testContext.getPageObjectManager().getAPTshirtsSectionPage();
	}
	
	@Then("^I should see the tshirts section$")
	public void i_should_see_the_tshirts_section() {
	    tshirtsSectionPage.verifyTshirtsPageTitle();
	}
	
	@When("^I choose medium size$")
	public void i_choose_medium_size() {
		
		tshirtsSectionPage.chooseMediumSize();
	}
	
	@When("^I add the faded short sleeve tshirt to the cart$")
	public void i_add_the_faded_short_sleeve_tshirt_to_the_cart() {
		
		tshirtsSectionPage.addFadedTshirtToCart();
	    
	}
	
	@When("^I choose proceed to checkout on tshirts selection page$")
	public void i_choose_proceed_to_checkout_on_tshirts_selection_page() {
	    tshirtsSectionPage.selectProceedToCheckout();
	}
	

}
