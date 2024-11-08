package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	WebElement logoHomePage;
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement clkSignup;
	
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']")
	WebElement NewUser;
	
	@FindBy(xpath="//i[@class='fa fa-user']/following::b")
	WebElement getUser;
	
	@FindBy(xpath="//a[normalize-space()='Delete Account']")
	WebElement deleteAccount;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement btnHome;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement clkLogOut;
	
	
	
	
	public boolean isHomePage() {
		return logoHomePage.isDisplayed();

	}
	
	public String clickSignup() {
		clkSignup.click();
		if(NewUser.isDisplayed()) {
			return "EnterCretendials";
		} else {
			return "click on Signup";
		}
	}
	
	public String getUserName() {
		return getUser.getText();

	}

	public void clickDeleteAccount() {
		deleteAccount.click();
		
	}
	
	public void clickHome() {
		btnHome.click();

	}
	
	public void clickLogOut() {
		clkLogOut.click();

	}
	
	public boolean isgetUserIsDisplayed() {
		return getUser.isDisplayed();

	}
}

 