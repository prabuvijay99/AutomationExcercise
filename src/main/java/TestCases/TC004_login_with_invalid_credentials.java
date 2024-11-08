package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.SignUpPage;

public class TC004_login_with_invalid_credentials extends commonMethods {
	
	@Test
	public void verify_invalid_credentials() {
		try
		{
		HomePage hp=new HomePage(getDriver());
		Assert.assertTrue(hp.isHomePage(),"Landed in HomePage");
		hp.clickSignup();		
		
		SignUpPage sup=new SignUpPage(getDriver());
		sup.sendLoginMail(prop.getProperty("userName"));
		sup.sendLoginpass(prop.getProperty("userPassWord1"));
		sup.clickLoginBtn();
		
		Assert.assertTrue(sup.getInvalidError(), "Invalid credentials message");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
	}

}
