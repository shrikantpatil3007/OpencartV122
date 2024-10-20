package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//input[@id='input-password']
	//input[@id='input-email']
	//input[@value='Login']
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement submit;
public void useremail(String mail) {
	email.sendKeys(mail);
}
public void userpwd(String pswd) {
	pwd.sendKeys(pswd);
}
public void submitting() {
	submit.click();
}
	
}
