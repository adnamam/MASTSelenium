package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends CommonUtils{

	/** Shared driver across pages */
	protected final WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getInputElFromLabelEl(String text) {
		WebElement el = driver.findElement(By.xpath("//*[contains(text(), '"+text+"')]"));
		String labelSub = el.getAttribute("id").substring(0,15);
		String newLabel = labelSub + "inputEl";
		return driver.findElement(By.id(newLabel));
	}
	
	
}
