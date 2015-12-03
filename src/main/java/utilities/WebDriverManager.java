package utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager extends ReadPropFile{
	
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
			driver = createDriver();
		}
		return driver;
	}

	/**
	 * Create a new driver.
	 * @return a new webdriver instance
	 */
	public WebDriver newDriver() {
		createDriver();
		return driver;
	}
	public WebDriver createDriver() {
		try {
			checkIfRemote();
		} catch (IOException e1) {
			throw new IllegalStateException("settings.properties file did not have isRemote field");
		}
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.ANY);
		capability.setJavascriptEnabled(true);
		capability = DesiredCapabilities.firefox();
		
		if (isRemote) {
			RemoteWebDriver driver = new FirefoxDriver(capability);
			
			try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
		else {
			WebDriver driver = new FirefoxDriver(capability);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
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
