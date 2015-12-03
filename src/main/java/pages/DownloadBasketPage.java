package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class DownloadBasketPage extends BasePage{

	public DownloadBasketPage(WebDriver driver) {
		super(driver);
	}
	
	/////////////
	//
	// WebElements
	//
	/////////////
	
	public WebElement recommendedProductsCheckbox() {
		return driver.findElement(By.id("checkbox-1581-inputEl"));
	}
	
	public WebElement removeSelectedButton() {	
		return driver.findElement(By.id("button-1892"));		
	}
	
	public WebElement dadsRequestButton() {	
		return driver.findElement(By.id("button-1461"));		
	}
	
	public WebElement downloadButton() {	
		return driver.findElement(By.id("button-1460"));		
	}
	
	/**
	 * checks if download basket window is displayed
	 * @return
	 */
	public boolean isWindowDisplayed() {
		return driver.findElement(By.id("window-1011")).isDisplayed();
	}
	
//	public boolean isRecommendedProductsChecked() {
//		return recommendedProductsCheckbox().isSelected();
//	}
//	

	/**
	 * checks hover text to tell if Removed Selected Items button is enabled
	 * @return
	 */
	public boolean isRemoveSelectedEnabled() {
		return removeSelectedButton().getAttribute("data-qtip").equals("Remove Selected Items");
	}
	

	/**
	 * checks hover text to tell if dads request button is enabled
	 * @return
	 */
	public boolean isDADSRequestEnabled() {
		return dadsRequestButton().getAttribute("data-qtip").equals("Initiate Dads Request");
	}

	/**
	 * Checks hover text to tell if Download button is enabled
	 * @return
	 */
	public boolean isDownloadItemsEnabled() {
		return downloadButton().getAttribute("data-qtip").equals("Download Selected Items");
	}
	
	/**
	 * Closes the download basket window
	 */
	public void closeWindow() {
		driver.findElement(By.id("tool-1545-toolEl")).click();
		
	}

}
