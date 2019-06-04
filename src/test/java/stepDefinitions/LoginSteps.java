package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageobjects.LoginPage;
import testDataTypes.Customer;

public class LoginSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	
	public LoginSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("^I want to open the wordpress website$")
	public void i_want_to_open_the_wordpress_website() throws Throwable {
		loginPage.navigateTo_HomePage();
	}

	@Given("^verify the website name$")
	public void verify_the_website_name() throws Throwable {
		loginPage.verifyLoginPageTitle();
	}

	@When("^I enter the \"([^\"]*)\" login details$")
	public void i_enter_the_login_details(String customerName) throws Throwable {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
	    loginPage.loginOperation(customer);
	}
	
	@When("^I input username and password with excel row \"([^\"]*)\" dataset$")
	public void i_input_username_and_password_with_excel_row_dataset(int rowIndex) throws Throwable {
	    Customer customer = FileReaderManager.getInstance().getExcelReader().readExcel(rowIndex);
	    loginPage.loginOperation(customer);
	}
	
	@When("^I click on login continue button$")
	public void i_click_on_login_continue_button() throws Throwable {
		loginPage.clickLoginButton();
	}

	@Then("^I verify the reader page title$")
	public void i_verify_the_reader_page_title() throws Throwable {
		loginPage.verifyReaderPageTitle();
	}

}
