package utilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Creates web drivers.
 */
public class WebDriverFactory extends CommonUtils{
	/**
	 * Creates the driver for firefox
	 * @throws MalformedURLException 
	 */
//	public static WebDriver createDriver() {
//		WebDriver driver;
//
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setPlatform(Platform.ANY);
//		capability.setJavascriptEnabled(true);
//		capability = DesiredCapabilities.firefox();
//		
//		
//		
//		driver = new FirefoxDriver(capability);
//
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//
//		return driver;
//		
//		
//////		RemoteWebDriver driver;
////		
////		DesiredCapabilities capability = new DesiredCapabilities();
////		capability.setPlatform(Platform.ANY);
////		capability.setJavascriptEnabled(true);
////		
////		capability = DesiredCapabilities.firefox();
//////		driver = new FirefoxDriver(capability);
////		RemoteWebDriver driver = null;
////		try {
////			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
////		} catch (MalformedURLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////		driver.manage().window().maximize();
////		
////		return driver;
//	}
	
	public WebDriver createRemoteDriver() {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.ANY);
		capability.setJavascriptEnabled(true);
		capability = DesiredCapabilities.firefox();
		
		RemoteWebDriver driver = new FirefoxDriver(capability);
		
		
//		try {
////		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
////	} catch (MalformedURLException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
//		return stuff();
	}
	
	public WebDriver stuff() {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.ANY);
		capability.setJavascriptEnabled(true);
		capability = DesiredCapabilities.firefox();
		
		if (isRemote) {
			RemoteWebDriver driver = new FirefoxDriver(capability);
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

}