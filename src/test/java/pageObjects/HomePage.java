package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//span[@class='caret']")
	WebElement accountfind;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement registerfind;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement findlogin;
	public void Accountclicked() {
		accountfind.click();
	}
	public void registerclicked() {
		registerfind.click();
	}
	public void loginclicked() {
		findlogin.click();
	}

}
