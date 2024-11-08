package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class TC001_VerifyHomePage extends commonMethods {
	
	@Test
	public void verify_home_page_isDisplayed() {
		try
		{

			HomePage hp=new HomePage(getDriver());
			boolean homePage = hp.isHomePage();
			Assert.assertTrue(homePage);
		}catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	

}
