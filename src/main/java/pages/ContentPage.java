package pages;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import popupPages.SpectralViewerPage;
import popupPages.TimeseriesViewerPage;
import utilities.BasePage;

public class ContentPage extends BasePage{
	
	//tip text for action buttons
	private static final String downloadNow = "Download Associated Data Now";
	private static final String downloadBasket = "Add Associated Files to Download Basket";
	private static final String showDetails= "Show Details";
	private static final String spectralViewer= "Spectral Viewer";
	private static final String focusAstroView= "Focus AstroView on these Coordinates";
	private static final String timeseriesViewer= "Timeseries Viewer";
	

	public ContentPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Clicks the first download now button listed in table
	 */
	public void clickFirstDownloadNow() {
		clickFirstActionButton(downloadNow);
	}
	
	/**
	 * Clicks the first add to basket button listed in table
	 * @throws MalformedURLException 
	 */
	public DownloadBasketPage clickFirstAddToBasket() throws MalformedURLException {
		clickFirstActionButton(downloadBasket);
		DownloadBasketPage db = getPage(DownloadBasketPage.class);
		waitForPageLoad(By.id("window-1011"));
		if(!db.isWindowDisplayed()) Assert.fail("Download Basket did not load");
		return db;
	}
	
	/**
	 * Clicks the first show details button listed in table
	 */
	public void clickFirstShowDetails() {
		clickFirstActionButton(showDetails);
	}
	
	/**
	 * Clicks the first spectral viewer button listed in table
	 * @return 
	 * @throws MalformedURLException 
	 */
	public SpectralViewerPage clickFirstSpectralViewer() throws MalformedURLException {
		clickFirstActionButton(spectralViewer);
		SpectralViewerPage sv = getPage(SpectralViewerPage.class);
		if(!sv.isPageDisplayed()) Assert.fail("Spectral Viewer did not load");
		return sv;
	}
	
	public TimeseriesViewerPage clickFirstTimeseriesViewer() throws MalformedURLException {
		clickFirstActionButton(timeseriesViewer);
		TimeseriesViewerPage tv = getPage(TimeseriesViewerPage.class);
		if(!tv.isPageDisplayed()) Assert.fail("Spectral Viewer did not load");
		return tv;
	}
	
	/**
	 * Clicks the first focus astroview button listed in table
	 */
	public void clickFirstFocusAstroView() {
		clickFirstActionButton(focusAstroView);
	}
	
	/**
	 * Clicks first action button
	 * @param action - tip text for action button
	 */
	private void clickFirstActionButton(String action) {
//		//set the action text 
//		String actionText = null;
//		switch(action) {
//		case downloadNow:
//			actionText = downloadNow;
//			break;
//		case downloadBasket:
//			actionText = downloadBasket;
//			break;
//		case showDetails:
//			actionText = showDetails;
//			break;
//		case spectralViewer:
//			actionText = spectralViewer;
//			break;
//		case focusAstroView:
//			actionText = focusAstroView;
//			break;
//		}
//		//get first row
////		WebElement tableEl = driver.findElement(By.tagName("table"));
//		WebElement tableEl = driver.findElement(By.id("tabpanel-1065-body"));
//		List<WebElement> tableRows = tableEl.findElements(By.tagName("tr"));
//		
//		WebElement firstTableRowEl = tableRows.get(0);
//		firstTableRowEl.click();
////		String text = firstTableRowEl.getText();
////		System.out.println(text);
//		//get action elements in first row
//		List<WebElement> actions= firstTableRowEl.findElements(By.xpath("*/div//*"));
//		
//		//check text for action element, click once text matches
//		for(int i=1; i<actions.size()-1; i++) {
//			WebElement currentEl = actions.get(i);
//			if (currentEl.getAttribute("data-qtip").equals(actionText)) {
//				currentEl.click();
//				break;
//			}
//		}		
////		this is what worked for specifically searching Saturn
////		firstTableRowEl.findElement(By.xpath("*/div//*[2]")).click();
//		
		
		String selText = "//*[@data-qtip='"+action+"']";
		driver.findElement(By.xpath(selText)).click();
		
	}
	
	public String getfirsRA() {
		return driver.findElement(By.xpath(".//*[@id='gridview-1149']/table/tbody/tr[1]/td[4]/div")).getText();
	}
	
	
	/**
	 * @param i - the observation to select - first one has value of 1
	 */
	public void selectObservation(int i) {
		List<WebElement> els = driver.findElements(By.className("x-grid-row-checker"));
		els.get(i-1).click();
	}
}