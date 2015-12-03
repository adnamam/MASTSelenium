package popupPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class CrossMatchPage extends BasePage{

	public CrossMatchPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isWindowDisplayed() {
		return driver.findElement(By.id("idCrossMatchContainer")).isDisplayed();
	}
	
	public By containerLocator() {
		return By.id("idCrossMatchContainer");
	}
	
	public void enterCatalog(String catalog) {
		WebElement catInput = driver.findElement(By.id("idCatalogTextField-inputEl"));
		catInput.clear();
		catInput.sendKeys(catalog);
	}
	
	public void clickCrossMatch() {
		driver.findElement(By.id("idCrossMatchButton")).click();
	}
	
	public void clickThing() {
		List<WebElement> els = driver.findElements(By.xpath("//td[starts-with(@id,'ext-gen')]"));
		int i = els.size();
		System.out.println(i);
		
	}

}
