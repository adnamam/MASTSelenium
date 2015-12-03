package tests;

import org.junit.Test;

import pages.HeaderPage;
import popupPages.AdvancedSearchPage;

public class AdvancedSearchTest extends BaseTest{
	
	@Test
	public void advancedSearchTest() {
		HeaderPage hp = getHeaderPage();
		AdvancedSearchPage as = hp.clickAdvancedSearch();

		//filter HST mission and verify breadcrumb is displayed
		as.clickFilterCheckbox("HST");
		as.getBreadCrumb("Mission: HST");
		as.stuff("Enter text here");
		
	}

}
