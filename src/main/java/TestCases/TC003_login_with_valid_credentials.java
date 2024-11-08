package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.SignUpPage;

public class TC003_login_with_valid_credentials extends commonMethods {
	
	@Test
	public void verify_valid_credentials() {
		try
		{
		HomePage hp=new HomePage(getDriver());
		Assert.assertTrue(hp.isHomePage(),"Landed in HomePage");
		hp.clickSignup();		
		
		SignUpPage sup=new SignUpPage(getDriver());
		sup.sendLoginMail(prop.getProperty("userName"));
		sup.sendLoginpass(prop.getProperty("userPassWord"));
		sup.clickLoginBtn();
		
		Assert.assertTrue(hp.isgetUserIsDisplayed(), "User name is Dipalyed");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			Assert.fail();
		}
	}

}
