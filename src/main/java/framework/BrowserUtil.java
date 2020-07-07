package framework;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {
	
	private static final Logger log = Logger.getLogger(BrowserUtil.class);
	public static WebDriver driver;
	public static WebDriverWait wait;

	/**
	 * This method clicks on a WebElement	 
	 * @param elem WebElement to be clicked
	 
	 */
	public static void click(WebElement elem) {
		log.info("click(WebElement elem) is invoked");
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
		log.info("click(WebElement elem) is completed");

	}
	
	public static void write(WebElement elem, String text) {
		log.info("write(WebElement elem) is invoked");
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.sendKeys(text);
		log.info("write(WebElement elem) is completed");
		
	}

	public static String getText(WebElement elem) {
		log.info("getText(WebElement elem) is invoked");
		return elem.getText().trim();
		
	}

}
