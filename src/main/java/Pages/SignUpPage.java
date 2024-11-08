package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends AccountStatusPage {
	public WebDriverWait wait;
	public Select slt;
	public SignUpPage(WebDriver driver) {
		
		super(driver);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	
	

	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement clkSignUp;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPass;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement clkDays;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement clkMonths;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement clkYears;
	
	@FindBy(xpath="//div[@class='checkbox']")
	List<WebElement> chkBox; 
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement Fname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement Lname;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement cmpny;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement Address2;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement clkcountry;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement txtState;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement txtCity;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement txtZip;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement txtPhone;
	
	@FindBy(xpath="//div[@class='radio-inline']//label")
	List<WebElement> genderTitle;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement btnCreateAcct;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement enterLoginmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement enterLoginpass;
	
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
	WebElement getErrorMsg;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")
	WebElement getUserExistError;
	
	
	
	public void sendLoginMail(String usermail) {
		enterLoginmail.sendKeys(usermail);

	}

	public void sendLoginpass(String userpass) {
		enterLoginpass.sendKeys(userpass);

	}
	
	public void clickLoginBtn() {
		btnLogin.click();

	}

	public void selectTitle(String mrMrs) {
		for(WebElement tit:genderTitle) {
			if (tit.getText().equalsIgnoreCase(mrMrs))
			{
			tit.click();
			}
			
		}
	}
	
	public void sendName(String name) {
		txtUserName.sendKeys(name);

	}
	
	public void sendEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void btnSignup() {
		clkSignUp.click();

	}
	
	public void sendPwd(String pwd) {
		txtPass.sendKeys(pwd);

	}
	
	public void dobDropDown(String date,String month,String year ) {
		wait.until(ExpectedConditions.visibilityOf(clkDays));
		Select day=new Select(clkDays);
		clkDays.click();
		day.selectByVisibleText(date);
		wait.until(ExpectedConditions.visibilityOf(clkMonths));
		Select mon=new Select(clkMonths);
		clkMonths.click();
		mon.selectByVisibleText(month);
		wait.until(ExpectedConditions.visibilityOf(clkYears));
		Select yr=new Select(clkYears);
		clkYears.click();
		yr.selectByVisibleText(year);
	}
	
	public void selectCheckBoxes() {
		for(WebElement cb:chkBox) {
			cb.click();
		}

	}
	
	public void sendDetails(String fname, String lname ,String cmpy) {
		Fname.sendKeys(fname);
		Lname.sendKeys(lname);
		cmpny.sendKeys(cmpy);

	}
	
	public void sendAddress(String add1,String add2,String ctry,String mobile) {
		Address1.sendKeys(add1);
		Address2.sendKeys(add2);
		Select slt=new Select(clkcountry);
		slt.selectByVisibleText(ctry);
		txtState.sendKeys("TamilNadu");
		txtCity.sendKeys("Chennai");
		txtZip.sendKeys("600056");
		txtPhone.sendKeys(mobile);
	}
	
	public void clickCreateAccount() {
		btnCreateAcct.click();
		
		}
	
	
	public boolean getInvalidError() {
		return getErrorMsg.isDisplayed();

	}
	
	public boolean checkUserisExisting() {
		return getUserExistError.isDisplayed();

	}
	}
	

