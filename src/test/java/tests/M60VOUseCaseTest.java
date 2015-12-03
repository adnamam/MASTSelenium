package tests;


import java.io.IOException;

import org.junit.Test;

public class M60VOUseCaseTest extends BaseTest{
	
	@Test
	public void spectralViewerTest() throws IOException {
		//perform search
//		getHeaderPage().searchForTarget("M60");
//		
//		//apply HST filters
//		FiltersPage filt = getPage(FiltersPage.class);
//		filt.filterHST();
//		
//		//change collection to VO and search
//		HeaderPage header = getPage(HeaderPage.class);
//		header.selectVOCollection(2);
//		header.searchForTarget("M60");
//		driverWait(20);
//		try {
//			driverWait(15).until(ExpectedConditions.invisibilityOfElementLocated(By.id("button-1465-btnIconEl")));
//		} catch (TimeoutException e) {
//			Assert.fail("Cancel icon still visible?");
//		}
		
//		filt.filterRecords("Chandra X-ray Observatory Data Archive");
//		driverWait();
		
		
		
		/**
		filt.filterSpectrum();
		filt.showAllInstrumentFilters();
		filt.filterSTIS_FUV_MAMA();
		
		//open spectral viewer
		SpectralViewerPage sv = cont.clickFirstSpectralViewer();

		
		//fitting
		sv.clickEnableFitting();
		Assert.assertTrue(sv.isDisabledFittingButtonDisplayed());
		sv.clickCanvas(450 , 300);
		Assert.assertTrue("Starting point did not display correctly", sv.startingPoint().contains("1) X:"));
		sv.clickCanvas(650, 270);
		Assert.assertTrue("", sv.endingPoint().contains("2) X"));
		
		//add rest wavelength
		sv.updateRestWavelength("1400");
		//verify redshift field is populated
		try {
			driverWait(5).until(ExpectedConditions.textToBePresentInElement(sv.redshiftTextEl(), "."));
		} catch (TimeoutException e) {
			Assert.fail("Redshift field was not populated after entering rest wavelength");
		}
		
		sv.updateWavelengthRange("1390", "1415");
		**/
	}

}
