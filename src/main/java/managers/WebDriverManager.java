package managers;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String USERNAME = "praveenkumar_dandu";
	private static final String ACCESS_KEY = "15d236a2-9b80-42e2-870b-c6139e0360f3";
	private static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
	
	public WebDriverManager()
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	public WebDriver getDriver() throws MalformedURLException{
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	public WebDriver createDriver() throws MalformedURLException{
		switch(environmentType){
		case LOCAL : driver = createLocalDriver();
		    break;
		case REMOTE : driver = createRemoteDriver();
		    break;
		}
		return driver;
	}
	
	private WebDriver createLocalDriver() {
		switch(driverType){
		case FIREFOX : driver = new FirefoxDriver();
		    break;
		case CHROME : driver = new ChromeDriver();
		    break;
		case INTERNETEXPLORER : driver = new InternetExplorerDriver();
		}
		
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver createRemoteDriver() throws MalformedURLException{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("platform", "macOS 10.13");
		caps.setCapability("version", "latest");
		driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
		
		//throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	public void quitDriver() {
		driver.close();
		driver.quit();
	}

}
