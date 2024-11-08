package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.SignUpPage;

public class TC005_logout_with_valid_credentials extends commonMethods {
	
	@Test
	public void verify_logOut_valid_credentials() {
		try
		{
		HomePage hp=new HomePage(getDriver());
		Assert.assertTrue(hp.isHomePage(),"Landed in HomePage");
		hp.clickSignup();		
		
		SignUpPage sup=new SignUpPage(getDriver());
		sup.sendLoginMail(prop.getProperty("userName"));
		sup.sendLoginpass(prop.getProperty("userPassWord"));
		sup.clickLoginBtn();
		
		
		hp.clickLogOut();
		String loginTitle = getDriver().getTitle();
		Assert.assertEquals(loginTitle, "Automation Exercise - Signup / Login");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			Assert.fail();
		}
	}

}
