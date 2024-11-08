package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AccountStatusPage;
import Pages.HomePage;
import Pages.SignUpPage;

public class TC007_login_Delete_account extends commonMethods {
	
	@Test
	public void verify_Delete_account() {
		try
		{
		HomePage hp=new HomePage(getDriver());
		Assert.assertFalse(hp.isHomePage(),"Landed in HomePage");
		hp.clickSignup();		
		
		SignUpPage sup=new SignUpPage(getDriver());
		sup.sendLoginMail(prop.getProperty("userName"));
		sup.sendLoginpass(prop.getProperty("userPassWord"));
		sup.clickLoginBtn();
		
		Assert.assertTrue(hp.isgetUserIsDisplayed(), "User name is Dipalyed");
		hp.clickDeleteAccount();
		AccountStatusPage asp=new AccountStatusPage(getDriver());
		asp.getAccountStatus();
		asp.ClickContinue();
		hp.clickHome();	
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			Assert.fail();
		}
	}

}
