package tests;

import org.junit.Test;

import pages.HeaderPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() {
		
		HeaderPage hp = getHeaderPage();
		hp.login();
		
	}

}
