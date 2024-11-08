package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AccountStatusPage;
import Pages.HomePage;
import Pages.SignUpPage;

public class TC006_Register_existing_user extends commonMethods {
	
	@Test
	public void Verify_Existing_user() {
		try
		{
			HomePage hp=new HomePage(getDriver());
			hp.clickSignup();
			SignUpPage sup=new SignUpPage(getDriver());
			String name = prop.getProperty("fname");
			sup.sendName(name);
			sup.sendEmail(prop.getProperty("userName"));
			sup.btnSignup();
			try {
				if(sup.checkUserisExisting())
				{
					System.out.println("User Existing!!");
					Assert.assertTrue(true);
				}
			}catch(Exception e)
			{
			e.getCause();	
			System.out.println("User not Existing!!");
			sup.selectTitle(prop.getProperty("female"));
			String randomPass = prop.getProperty("userPassWord");
			System.out.println(randomPass);
			sup.sendPwd(randomPass);
			sup.dobDropDown("11", "June", "1991");
			sup.selectCheckBoxes();
			sup.sendDetails(name, "c", "TCS");
			sup.sendAddress("Sri Palace", "Iyyappanthangal", "India", "978987898");
			sup.clickCreateAccount();
			
			AccountStatusPage asp=new AccountStatusPage(getDriver());
			asp.getAccountStatus();
			asp.ClickContinue();
			String userName = hp.getUserName();
			Assert.assertEquals(userName, name);
		}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		

	}

	
	

}
