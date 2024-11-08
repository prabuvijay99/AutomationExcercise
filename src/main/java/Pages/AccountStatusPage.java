package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountStatusPage extends BasePage {
	
	public AccountStatusPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[@class='title text-center']/b")
	WebElement accountStatus;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement btnContinue;	
		
	public void ClickContinue() {
		btnContinue.click();

	}
	
	public String getAccountStatus() {
		System.out.println(accountStatus.getText());
		return accountStatus.getText();
	}
	
}
