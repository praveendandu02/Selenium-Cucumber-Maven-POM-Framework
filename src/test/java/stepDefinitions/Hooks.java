package stepDefinitions;


import com.cucumber.listener.Reporter;
import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	TestContext testContext;
	
	
	
	public Hooks(TestContext context) {
		
		testContext = context;
	}

	@Before
	public void beforeScenario(Scenario scenario)
	{
		System.out.println("test context: "+ testContext);
		//Reporter.assignAuthor("praveendandu");
		
	}
	
	@After
	public void closeApplication()
	{
		testContext.getWebDriverManager().quitDriver();
	}

}
