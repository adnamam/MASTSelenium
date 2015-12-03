package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import pages.ContentPage;
import pages.FiltersPage;
import popupPages.TimeseriesViewerPage;

public class TimeseriesViewerTest extends BaseTest{
	
	@Test
	public void timeseriesViewerTest() throws MalformedURLException {
		//perform search
		ContentPage cont = getHeaderPage().searchForTarget("tres2");
		
		//apply filters
		FiltersPage filt = getPage(FiltersPage.class);
		filt.filterTimeseries();
		TimeseriesViewerPage tv = cont.clickFirstTimeseriesViewer();
		
		//add period
		tv.clickPhaseFoldingHeader();
		tv.addPeriod("2.74");
		String initPeriod = tv.periodInputEl().getAttribute("value");
		//increase phase by +.01
		tv.addIncrement(".01");
		tv.increaseIncrement();
		
		//get current value held in period field
		String curPeriod = tv.periodInputEl().getAttribute("value");
		Assert.assertFalse("Period was not increased aftet clicking + button", curPeriod.equals(initPeriod));
		
		
	}

}
