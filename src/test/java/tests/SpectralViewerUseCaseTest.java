package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import pages.ContentPage;
import pages.FiltersPage;
import popupPages.SpectralViewerPage;

public class SpectralViewerUseCaseTest extends BaseTest{
	
	@Test
	public void spectralViewerTest() throws IOException {
		//perform search
		ContentPage cont = getHeaderPage().searchForTarget("LkCa 4");
		
		//apply filters
		FiltersPage filt = getPage(FiltersPage.class);
		filt.filterSpectrum();
		filt.showAllInstrumentFilters();
		filt.filterSTIS_FUV_MAMA();
		
		//open spectral viewer
		SpectralViewerPage sv = cont.clickFirstSpectralViewer();

		
		//fitting
		sv.clickFittingHeader();
		sv.clickEnableFitting();
		//verify fitting is enabled
		Assert.assertTrue(sv.isDisabledFittingButtonDisplayed());
		sv.clickCanvas(450 , 300);
		//verify starting point was drawn
		Assert.assertTrue("Starting point did not display correctly", sv.startingPoint().contains("1) X:"));
		sv.clickCanvas(650, 270);
		//verify ending point was drawn
		Assert.assertTrue("Ending point did not display correctly", sv.endingPoint().contains("2) X"));
		
		//add rest wavelength
		sv.updateRestWavelength("1400");
		String z = sv.redshiftTextEl().getAttribute("value");
		Assert.assertTrue("Redshift was not calculated", z.contains("-0."));
		
		sv.clickRangeHeader();
		sv.updateWavelengthRange("1390", "1415");
	}

}
