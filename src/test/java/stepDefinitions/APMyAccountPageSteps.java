package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.APMyAccountPage;

public class APMyAccountPageSteps {
	TestContext testContext;
	APMyAccountPage myAccountPage;
	
	public APMyAccountPageSteps(TestContext context) {
		testContext = context;
		myAccountPage = testContext.getPageObjectManager().getAPMyAccountPage();
	}
	
	@Then("^I should see the my account page$")
	public void i_should_see_the_my_account_page() {
	    myAccountPage.verifyMyAccountPageTitle();
	}
	
	@When("^I choose the option women and choose tshirts$")
	public void i_choose_the_option_women_and_choose_tshirts() {
	    myAccountPage.navigateTo_TshirtsPage();
	}

}
