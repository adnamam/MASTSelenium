package popupPages;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class AdvancedSearchPage extends BasePage{

	public AdvancedSearchPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Gets breadcrumb element listed on top of page
	 * Asserts failure if element is not found
	 * @param text - text of breadcrumb element
	 */
	public void getBreadCrumb(String text) {
		try {
			driver.findElement(By.xpath("//label[contains(text(), '"+text+"')]"));
		} catch (InvalidSelectorException e) {
			Assert.fail(text +" breadcrumb is not listed on Advanced Search page.");
		}
	}
	
	/**
	 * Clicks checkbox for a filter element
	 * @param text
	 */
	public void clickFilterCheckbox(String text) {
		List<WebElement> els = getElsListContainingText(text);
		els.get(0).click();
	}
	
	
	public void stuff(String text) {
//		List<WebElement> els = driver.findElements(By.cssSelector("a[data-qtip='"+text+"'"));
//		System.out.println(els.size());
		List<WebElement> els = driver.findElements(By.xpath("//input[@placeholder='"+text+"']"));
		System.out.println(els.size());
	}


}
