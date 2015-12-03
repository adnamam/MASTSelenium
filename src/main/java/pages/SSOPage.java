package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.BasePage;

public class SSOPage extends BasePage{

	public SSOPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @param email
	 * @param pw
	 */
	public void enterAndSubmitLoginInfo(String email, String pw) {
		//enter username
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(email);
		//enter pw
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pw);
		//click login button
//		driver.findElement(By.id("btn-submit")).click();
		driver.findElement(By.className("btn-submit")).click();
	}

}
