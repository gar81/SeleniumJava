package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

public class BaseTest {
	public String secretKey;
	
	private static final Logger log = Logger.getLogger(BaseTest.class);
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeSuite
	public void beforeSuiteSetup() {
		// reports configuration ll come here.
	}

	@AfterSuite
	public void AfterSuiteTeardown() {
	}
	
	@Parameters({ "browser", "grid", "implicitWait", "explicitWait", "secretKey" })
	@BeforeTest		
	public void beforeTestRun(String browser, String grid, int implicitWait, int explicitWait, String secretKey) {
		this.secretKey = secretKey;
		log.info("************TestCase Execution starts*****************");
		initWebDriver(browser);
		configureDriver(implicitWait, explicitWait);
	}

	@AfterTest
	public void AfterTestRun() {
		//driver.quit();
		closeWebDriver();
		log.info("************TestCase Execution ends*****************");
	}

	// initWebDriver() method defined here
	private void initWebDriver(String browser) {

		log.info("Driver initialization i.e initWebDriver() method started");
		try {
			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
			default:
				break;
			}
		log.info("Driver initialization completed");	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	//configureDriver() method body with wait configuration defined here.
	private void configureDriver(int implicitWait, int explicitWait) {
		log.info("Driver configuration started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, explicitWait);
		log.info("Driver configuration ended");

	}

	private void closeWebDriver() {
		driver.quit();
	}
}
