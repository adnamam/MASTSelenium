package tests;

import java.io.IOException;

import org.junit.Test;

import pages.OptionsPanelPage;
import popupPages.CrossMatchPage;

public class CrossMatchTest extends BaseTest {
	
	@Test
	public void crossMatchTest() throws IOException {
		getHeaderPage().searchForTarget("M60");
		OptionsPanelPage opp = getPage(OptionsPanelPage.class);
		CrossMatchPage cm = opp.clickCrossMatch();
		cm.clickThing();
	}

}
