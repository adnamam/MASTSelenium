package popupPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class TimeseriesViewerPage extends BasePage{

	public TimeseriesViewerPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @return returns true of timeseries viewer page is displayed
	 */
	public boolean isPageDisplayed() {
//		return driver.findElement(By.id("window-1500")).isDisplayed();
		//TODO hopefully replace this once things are named
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'Phase Folding')]")).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			Assert.fail("Spectral Viewer did not open");
			return false;
		}
	}
	
	/////////////////
	//
	// Phase Folding
	//
	/////////////////
	
	
	/**
	 * Clicks Phase Folding header to expand/collapse section
	 */
	public void clickPhaseFoldingHeader() {
		getFirstEl("Phase Folding").click();
	}
	
	public WebElement periodInputEl() {
		return getInputElFromLabelEl("Period (days):");
	}
	
	public WebElement incrementInputEl() {
		return getInputElFromLabelEl("Increment by:");
	}
	
	public WebElement epochInputEl() {
		return getInputElFromLabelEl("Epoch:");
	}
	
	/**
	 * Adds given text to period text entry field
	 * @param p
	 */
	public void addPeriod(String p) {
		periodInputEl().clear();
		periodInputEl().sendKeys(p);
	}
	
	/**
	 * adds given text to increment by field
	 * @param i
	 */
	public void addIncrement(String i) {
		incrementInputEl().clear();
		incrementInputEl().sendKeys(i);
	}
	
	/**
	 * if true - clicks the + box to increase period by given increment amount
	 * if false - clicks the - box to decrease period by given increment amount
	 * @param increase
	 */
	private void changeIncrement(boolean increase) {
		int labelNum = 0;
		WebElement el = getFirstEl("Increment by:");
		String labelSub = el.getAttribute("id").substring(10,14);
		if (increase) labelNum = Integer.parseInt(labelSub) +1;
		else labelNum = Integer.parseInt(labelSub) +2;
		String newLabel = "button-" + String.valueOf(labelNum) + "-btnIconEl";
		System.out.println(newLabel);
		driver.findElement(By.id(newLabel)).click();
	}
	
	/**
	 * clicks the + box to increase period by given increment amount
	 */
	public void increaseIncrement() {
		changeIncrement(true);
	}
	
	/**
	 * clicks the - box to decrease period by given increment amount
	 */
	public void decreaseIncrement() {
		changeIncrement(false);
	}

}
