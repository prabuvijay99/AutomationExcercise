package TestCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AccountStatusPage;
import Pages.HomePage;
import Pages.SignUpPage;

public class TC002_Register_User extends commonMethods {
	
	@Test
	public void Verify_register_user() {
		try
		{
		HomePage hp=new HomePage(getDriver());
		hp.clickSignup();
		
		SignUpPage sup=new SignUpPage(getDriver());
		fname = RandomUserName();
		sup.sendName(fname);
		System.out.println(fname+"@gmail.com");
		sup.sendEmail(fname+"@gmail.com");
		sup.btnSignup();
		sup.selectTitle(prop.getProperty("female"));
		String randomPass = RandomPass();
		System.out.println(randomPass);
		sup.sendPwd(randomPass);
		sup.dobDropDown("11", "June", "1991");
		sup.selectCheckBoxes();
		sup.sendDetails(fname, "c", "TCS");
		sup.sendAddress("Sri Palace", "Iyyappanthangal", "India", "978987898");
		sup.clickCreateAccount();
		
		AccountStatusPage asp=new AccountStatusPage(getDriver());
		asp.getAccountStatus();
		asp.ClickContinue();
		String userName = hp.getUserName();
		Assert.assertEquals(userName, fname);
		
		hp.clickDeleteAccount();
		
		Assert.assertEquals(asp.getAccountStatus(),"ACCOUNT DELETED!");
		asp.ClickContinue();
		hp.clickHome();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		

	}

	
	

}
