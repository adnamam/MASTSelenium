package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class FiltersPage extends BasePage{

	public FiltersPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @param s - which radio button you want to select:
	 * 1: all; 2: checked; 3: unchecked
	 */
	public void filterRadioButtons(int s) {
		driver.findElement(By.id("radiofield-112"+s+"-inputEl")).click();
	}
	
	public void getTabs() {
		//get all of the tab elements
		List<WebElement> tabs = driver.findElements(By.cssSelector("a[id*='tab-10']"));
		//get the first child of the tabs
		List<WebElement> tabChildren = tabs.get(0).findElements(By.xpath(".//*"));
		System.out.println(tabChildren);
		
		for(int i=0; i<tabChildren.size()-1; i++) {
			System.out.println(tabs.get(i).getText());
		}
	}
	
	public void clickImageFilter() {
		driver.findElement(By.id("checkbox-4208-inputEl")).click();
	}

	public void stuff() {
		driver.findElements(By.xpath("//input[starts-with(@id,'checkbox-')]"));
		driver.findElements(By.cssSelector("input[id*='tab-10']"));
	}
	
	/**
	 * Clicks the spectrum checkbox
	 */
	public void filterSpectrum() {
//		driver.findElement(By.id("checkbox-1108-inputEl")).click();
		filterElement("spectrum");
	}
	
	public void filterTimeseries() {
		filterElement("timeseries");
//		checkbox-1105-inputEl
	}
	
	/**
	 * Clicks the HST checkbox
	 */
	public void filterHST() {
		filterElement("HST");
	}
	
	private void filterElement(String filter) {
		driver.findElement(By.xpath("//*[contains(text(), '"+filter+"')]")).click();
		try {
			driverWait(2);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Clicks the show more button for the instruments filter
	 */
	public void showAllInstrumentFilters() {
		driver.findElement(By.id("button-1141-btnIconEl")).click();
	}
	
	public void filterSTIS_FUV_MAMA() {
		filterElement("STIS/FUV-MAMA");
	}
	
	/**
	 * Enter text in filter field and search
	 */
	public void filterRecords(String input){
		WebElement filter = driver.findElement(By.xpath("//*[@placeholder='Filter All Records']"));
		filter.clear();
		filter.sendKeys(input);
		
		driver.findElement(By.id("searchbox-1084-inputEl")).sendKeys(input);
		driver.findElement(By.id("ext-gen1335")).click();
	}
	
	/**
	 * Clicks the image checkbox
	 */
	public void filterImage(){
		driver.findElement(By.id("checkbox-1105-inputEl")).click();
//		filterElement("image");
	}
	
	
	public void filterDADS(){
		driver.findElement(By.id("checkbox-1171-inputEl")).click();
//		filterElement("DADS");
	}
	
	
	public void filterACS(){
		driver.findElement(By.id("checkbox-1152-inputEl")).click();
//		filterElement("ACS/WFC");
	}
	
	
	public void filterHLA(){
		driver.findElement(By.id("checkbox-1177-inputEl")).click();
//		filterElement("HLA");
	}
	
	
	public void clearFilter(){
		driver.findElement(By.id("button-1097-btnIconEl")).click();
	}
	
	public void checkFilterResult(String result, String filterName){
		try{
			assertEquals(result, driver.findElement(By.cssSelector("b")).getText());
		}
		catch(Error e){
			String verificationErrorString = "Search--" + filterName + "--" + e.toString();
			System.out.println(verificationErrorString);
			if (!"".equals(verificationErrorString)) {
			      fail(verificationErrorString);
			    }
		}
	}
}

