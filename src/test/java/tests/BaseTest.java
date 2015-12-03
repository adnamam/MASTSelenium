package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HeaderPage;
import utilities.CommonUtils;
import utilities.WebDriverManager;

public class BaseTest extends CommonUtils{
	
	public HeaderPage getHeaderPage() {
		driver().get(getURL());
		return getPage(HeaderPage.class);
	}
	
	/**
	 * Get a page with the default driver
	 * 
	 * @param page the class object of the page to retrieve
	 * @return the page
	 */
	public static <T> T getPage(Class<T> page) {
		try {
			return PageFactory.initElements(driver(), page);
		}
		catch (Exception e) {
			throw new IllegalStateException("Failed to load page: " + page.getName(), e);
		}
	}
	
	public static WebDriver driver() {
		return WebDriverManager.get().driver();
	}
	
	@After
	public void cleanUp() {
		WebDriverManager.get().quit();
	}

}
