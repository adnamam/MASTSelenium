package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import popupPages.CrossMatchPage;
import utilities.BasePage;

public class OptionsPanelPage extends BasePage{

	public OptionsPanelPage(WebDriver driver) {
		super(driver);
	}
	
	public CrossMatchPage clickCrossMatch() throws MalformedURLException {
//		driver.findElement(By.xpath("//*[@data-qtip='Cross-Match this table with other Catalogs']"));
		driver.findElement(By.cssSelector("a[data-qtip='Cross-Match this table with other Catalogs']")).click();
		return getPage(CrossMatchPage.class);
	}

}
