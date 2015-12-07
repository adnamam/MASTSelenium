package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class WebDriverManager {
	
	/** WebDriver instance. */
	private WebDriver driver;

	/******************************/
	/** Helpers for driver usage **/
	/******************************/

	/**
	 * Quits and removes the driver
	 */
	public void quit() {
		if (driver == null) {
			return;
		}
		try {
			driver().quit();
			driver = null;
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the currently used driver instance (or make a new one if needed).
	 * 
	 * @return a webdriver instance
	 */
	public WebDriver driver() {
		if (driver == null) {
			driver = WebDriverFactory.createDriver();
		}
		return driver;
	}

	/**
	 * Create a new driver.
	 * @return a new webdriver instance
	 */
	public WebDriver newDriver() {
		WebDriverFactory.createDriver();
		return driver;
	}

	/***********************************/
	/** Typical singleton boilerplate **/
	/***********************************/

	/** Typical singleton placeholder */
	private static WebDriverManager INSTANCE;

	/**
	 * Typical singleton accessor (not threadsafe)
	 * 
	 * @return the driver manager
	 */
	public static WebDriverManager get() {
		if (INSTANCE == null) {
			INSTANCE = new WebDriverManager();
		}
		return INSTANCE;
	}

	/** Typical singleton constructor */
	private WebDriverManager() {
	}

}