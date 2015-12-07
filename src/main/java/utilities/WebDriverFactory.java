package utilities;

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
	 * Creates the driver for chrome
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
	}

}