package seleniumProj.utilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Creates web drivers.
 */
public class WebDriverFactory {
	/**
	 * Creates the driver for firefox
	 * @throws MalformedURLException 
	 */
	public static WebDriver createDriver() {
		WebDriver driver;

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.ANY);
		capability.setJavascriptEnabled(true);

		capability = DesiredCapabilities.firefox();
		driver = new FirefoxDriver(capability);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
		
		
//		RemoteWebDriver driver;
		
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setPlatform(Platform.ANY);
//		capability.setJavascriptEnabled(true);
//		
//		capability = DesiredCapabilities.firefox();
//		driver = new FirefoxDriver(capability);
//		RemoteWebDriver driver = null;
//		try {
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		
//		return driver;
	}

}