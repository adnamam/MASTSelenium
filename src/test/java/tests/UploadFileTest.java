package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import pages.ContentPage;
import pages.HeaderPage;

public class UploadFileTest extends BaseTest{
	
	String filename = "sn2005.csv";
	
	@Test
	public void uploadFileTest() throws IOException {
		HeaderPage hp = getHeaderPage();
		hp.clickImportTargetList();
		hp.uploadFile("/Users/amarrione/Downloads/" + filename);
		
		ContentPage cp = getPage(ContentPage.class);
		String raText = cp.getfirsRA();
		String tab = hp.getTabText();
		//verify data for uploaded file is listed
		Assert.assertTrue("Text for first RA field in uploaded file did not match expected text", raText.equals("02:30:43.250"));
		//check tab was opened that contains name of file
		Assert.assertTrue("Content tab for file upload did not match expected value", tab.equals(filename));
	}

}
