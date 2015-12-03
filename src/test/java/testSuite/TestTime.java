package testSuite;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import pages.ContentPage;
import pages.DownloadBasketPage;
import pages.HeaderPage;
import tests.BaseTest;

public class TestTime extends BaseTest{
	
	@Test
	public void doStuff() throws IOException {
		HeaderPage header = getHeaderPage();
		ContentPage contentPage = header.searchForTarget("saturn");
//		getPage(FiltersPage.class).stuff();
		
		contentPage.clickFirstAddToBasket();
		
		DownloadBasketPage db = getPage(DownloadBasketPage.class);
		Assert.assertTrue(db.isWindowDisplayed());
//		Assert.assertTrue(db.isRecommendedProductsChecked());
//		db.closeWindow();
		//TODO fix close window :(
	}

}
