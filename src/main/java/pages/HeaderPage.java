package pages;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import popupPages.AdvancedSearchPage;
import utilities.BasePage;

public class HeaderPage extends BasePage {

	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	public AdvancedSearchPage clickAdvancedSearch() {
		driver.findElement(By.linkText("Advanced Search")).click();
		AdvancedSearchPage as = null;
		try {
			as = getPage(AdvancedSearchPage.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return as; 
	}
	
	/**
	 * Performs search and returns the Observations List Page
	 * @param searchText
	 * @return
	 * @throws MalformedURLException 
	 */
	public ContentPage searchForTarget(String searchText) throws MalformedURLException {
		WebElement searchBox = driver.findElement(By.id("textfield-1031-inputEl"));
		searchBox.clear();
		searchBox.sendKeys(searchText);
		driver.findElement(By.id("button-1032-btnInnerEl")).click();
		driverWait();
//		waitForPageLoad(By.xpath("//*[text()='MAST: saturn']"));
		waitForPageLoad(By.xpath("//a[contains(@data-qtip,'A List of Observations for ')]"));
		return getPage(ContentPage.class);
	}
	
	/**
	 * Selects Virtual Observatory from collection dropdown
	 */
	public void selectVOCollection(int selection) {
		driver.findElement(By.xpath("//*[@value='All MAST Observations']")).click();
		driver.findElement(By.xpath("//*[text()='All Virtual Observatory Collections']")).click();
	}
	
	/**
	 * Gets text of tab on page
	 * @return
	 */
	public String getTabText() {
		return driver.findElement(By.id("tab-1099-btnInnerEl")).getText();
	}
	
	public void login() {
		SSOPage sso= null;
		String parentHandle = driver.getWindowHandle(); //get current window
		
		//click login button on the portal
		driver.findElement(By.id("idLoginButton-btnInnerEl")).click();
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //switch webdriver focus to sso window
		}
		
		try {
			sso = getPage(SSOPage.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.fail("SSO page was not opened");
		}
		
		sso.enterAndSubmitLoginInfo("masttestusertwo@gmail.com", "GilligansIsland1");
		driver.switchTo().window(parentHandle); // switch back to the original window
	}
	
	
	/////////////////
	//
	// importing
	//
	/////////////////
	
	/**
	 * clicks upload target list button
	 */
	public void clickImportTargetList() {
		driver.findElement(By.id("button-1037")).click();
		//waits for import file dialog to open
		waitForPageLoad(By.id("ext-comp-1056"));
	}
	
	/**
	 * imports given file - assumes valid file will be given
	 * @param filePath - the path to the file to import
	 */
	public void uploadFile(String filePath) {
		//select file
		WebElement fileInput = driver.findElement(By.id("form-file-button-fileInputEl"));
		fileInput.sendKeys(filePath);
		//click import
		uploadButton().click();
		//wait for page with table info from file to load
		waitForPageLoad(By.xpath("//*[text()='Filters']"));
		
	}
	
	/**
	 * holds webelement for import button in the import dialog
	 * @return
	 */
	private WebElement uploadButton() {
		return driver.findElement(By.id("button-1064-btnIconEl"));
	}
	
	/**
	 * selects file format importing files
	 * @param format
	 */
	public void selectImportFileFormat(String format) {
		driver.findElement(By.id("combobox-1059-inputEl")).click();
		
		//select correct dropdown
		if (format.equals("CSV")) {
			driver.findElement(By.xpath("//*[text()='CSV']")).click();
		}
		else if (format.equals("VO Table")) {
			driver.findElement(By.xpath("//*[text()='VO Table']")).click();
		}
		else {
			Assert.fail("Invalid file format chosen");
		}
		
	}
		

	
		
		//interacting with search results
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.id("tabpanel-1054-body"));
//		driver.findElement(By.id("ext-comp-1396-body"));
//		driver.findElement(By.xpath(".//*[@id='ext-comp-1396-body']"));
//		WebElement el = driver.findElement(By.id("gridview-1425-body"));
//		List<WebElement> stuff = el.findElements(By.tagName("tr"));
//		String text = stuff.get(0).getText();
		
		
		//////DATABASE STUFF
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		DriverManager.getConnection("TerminalServer.stsci.edu", user, password)

}