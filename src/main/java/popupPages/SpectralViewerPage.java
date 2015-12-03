package popupPages;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BasePage;

/**
 * holds methods/actions for the spectral viewer page
 * @author amarrione
 *
 */
public class SpectralViewerPage extends BasePage{

	public SpectralViewerPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @return returns true of spectral viewer page is displayed
	 */
	public boolean isPageDisplayed() {
//		return driver.findElement(By.id("window-1500")).isDisplayed();
		//TODO hopefully replace this once things are named
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'Smooth Factor:')]")).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			Assert.fail("Spectral Viewer did not open");
			return false;
		}
	}
	
	/**
	 * update the wavelength range 
	 * @param min - min wavelength
	 * @param max - max wavelength
	 */
	public void updateWavelengthRange(String min, String max) {
		List<WebElement> els = driver.findElements(By.xpath("//input[starts-with(@id,'textfield-')]"));
		WebElement wavelengthRangeMin = els.get(15);
		WebElement wavelengthRangeMax = els.get(16);
		wavelengthRangeMin.clear();
		wavelengthRangeMin.sendKeys(min);
		wavelengthRangeMax.clear();
		wavelengthRangeMax.sendKeys(max);
	}
	
	/**
	 * Clicks Fitting header to expand/collapse section
	 */
	public void clickFittingHeader() {
		getFirstEl("Fitting").click();
	}
	
	/**
	 * Clicks Range header to expand/collapse section
	 */
	public void clickRangeHeader() {
		getElsListContainingText("Range").get(7).click();
	}
	
	/**
	 * Enters the given string into the wavelength text box in the 
	 * wavelength indicator section
	 * @param wl - the desired wavelength to indicate
	 */
	public void updateWavelengthIndicator(String wl) {
		List<WebElement> el = driver.findElements(By.xpath("//input[starts-with(@id,'textfield')]"));
		el.get(18).clear();
		el.get(18).sendKeys(wl);
	}
	
	/**
	 * Enters the given string into the rest wavelength text box
	 * @param wl - the rest wavelength
	 */
	public void updateRestWavelength(String wl) {
		restWavelengthInputEl().clear();
		restWavelengthInputEl().sendKeys(wl);
		restWavelengthInputEl().sendKeys(Keys.ENTER);
		try {
			driverWait(1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeIndicatorColor() {
//		driver.findElement(By.id("ext-gen6941")).click();
//		List<WebElement> el = driver.findElements(By.xpath("//*[starts-with(@id,'ext-gen')]"));
		List<WebElement> el = driver.findElements(By.xpath("//a[@role = 'button']"));
		System.out.print(el.size());
		driver.findElement(By.className("color-FF0000 x-color-picker-item")).click();
	}
	
	private WebElement enableFittingButton() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Enable Fitting')]"));		
	}
	
	private WebElement disableFittingButton() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Disable Fitting')]"));		
	}
	
	public void clickEnableFitting() {
		enableFittingButton().click();
	}
	
	/**
	 * clicks the disable fitting button 
	 */
	public void clickDisableFitting() {
		disableFittingButton().click();
	}
	
	/**
	 * @return - true if the disable fitting button is displayed
	 */
	public boolean isDisabledFittingButtonDisplayed() {
		return disableFittingButton().isDisplayed();
	}
	
	/**
	 * Clicks the plot at the given coordinates.
	 * Note- (0,0) is the top left of the canvas and 
	 * its max size is (1597, 569)
	 */
	public void clickCanvas(int x, int y) {
		List<WebElement> canvasEls = driver.findElements(By.className("jqplot-event-canvas"));
		
		//used to get position of desired canvas el
//		for(int i=0; i<canvasEls.size(); i++) {
//			String wid = canvasEls.get(i).getAttribute("width");
//			System.out.println(wid);
//		}
		
		WebElement canvas = canvasEls.get(7);
		Actions builder = new Actions(driver);
		builder.moveToElement(canvas, x, y).click().build().perform();
	}
	
	/**
	 * Gets text of starting point for fitting line to graph 
	 * @return
	 */
	public String startingPoint() {
		return driver.findElement(By.xpath("//*[contains(text(), '1) X:')]")).getText();
	}
	
	/**
	 * Gets text of ending point for fitting line to graph
	 * @return
	 */
	public String endingPoint() {
		return driver.findElement(By.xpath("//*[contains(text(), '2) X:')]")).getText();
	}
	
	/**
	 * gets webel of text listed for redshift
	 * by finding id of label for redshift
	 * @return
	 */
	public WebElement redshiftTextEl() {
		return getInputElFromLabelEl("Redshift (z):");
	}
	
	/**
	 * gets webel for rest wavelength input field by finding
	 * id of label for rest wavelength
	 * @return
	 */
	private WebElement restWavelengthInputEl() {
		return getInputElFromLabelEl("Rest Wavelength:");	
	}

 }
