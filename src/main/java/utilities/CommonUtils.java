package utilities;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils extends ReadPropFile{

	public static final int IMPLICIT_WAIT = 3;
	public static final int IMPLICIT_WAIT_LONG = 6;

	/**
	 * Instantiate a page object with the currently active (or new if none)
	 * driver
	 *
	 * @param pageClass
	 *            the page to load
	 * @return the page object
	 * @throws MalformedURLException 
	 */
	public static <T> T getPage(Class<T> pageClass) throws MalformedURLException {
		return PageFactory.initElements(driver(), pageClass);
	}

	public static WebDriver driver() throws MalformedURLException {
		return WebDriverManager.get().driver();
	}

	/**
	 * Get a driver wait object with the default implicit wait time
	 * 
	 * @return a default WebDriverWait object
	 * @throws MalformedURLException 
	 */
	public static WebDriverWait driverWait() throws MalformedURLException {
		return driverWait(IMPLICIT_WAIT_LONG);
	}

	/**
	 * Get a driver wait object with the provided timeout
	 * 
	 * @param timeoutInSeconds
	 *            the maximum wait time in seconds
	 * @return a WebDriverWait object
	 * @throws MalformedURLException 
	 */
	public static WebDriverWait driverWait(int timeoutInSeconds) throws MalformedURLException {
		return new WebDriverWait(driver(), timeoutInSeconds);
	}
	
	public void waitForPageLoad(By By) {
		try {
			driverWait().until(ExpectedConditions.presenceOfElementLocated(By));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * gets list of elements that contain the given txt
	 * @param text
	 * @return
	 */
	public List<WebElement> getElsListContainingText(String text) {
		List<WebElement> els = null;
		try {
			els = driver().findElements(By.xpath("//*[contains(text(), '"+text+"')]"));
		} catch (MalformedURLException e) {
			Assert.fail("Element with text "+text+" was not found");
			e.printStackTrace();
		}
		return els;
	}
	
	/**
	 * Gets first element from list of webelements
	 * @param els
	 * @return
	 */
	public WebElement getFirstEl(String text) {
		List<WebElement> els = getElsListContainingText(text);
		return els.get(0);
	}

}
