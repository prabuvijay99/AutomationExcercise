package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AccountStatusPage;
import Pages.HomePage;
import Pages.SignUpPage;
import Utils.DataProviders;

public class TC008_Register_User_TDD extends commonMethods {
	
	@Test(dataProvider = "UserData",dataProviderClass =DataProviders.class )
	public void Verify_register_user_test_data(String fname,String mail,String Title,String Pass,
												String day,String month,String year,
												String Fname,String Lname, String company,
												String Addr1,String Addr2,String country,String mobile) {
		try
		{
		HomePage hp=new HomePage(getDriver());
		hp.clickSignup();
		
		SignUpPage sup=new SignUpPage(getDriver());
//		fname = RandomUserName();
		sup.sendName(fname);
//		System.out.println(fname+"@gmail.com");
		sup.sendEmail(mail);
		sup.btnSignup();
		sup.selectTitle(Title);
//		String randomPass = RandomPass();
//		System.out.println(randomPass);
		sup.sendPwd(Pass);
		sup.dobDropDown(day, month, year);
		sup.selectCheckBoxes();
		sup.sendDetails(Fname, Lname, company);
		sup.sendAddress(Addr1, Addr2, country, mobile);
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
