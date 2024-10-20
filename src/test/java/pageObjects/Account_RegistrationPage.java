package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_RegistrationPage extends BasePage {
    WebDriver driver;
    public Account_RegistrationPage(WebDriver driver) {
    	super(driver);
    }
    

  //input[@id='input-lastname']
  //input[@id='input-firstname']
  //input[@id='input-email']
  //input[@id='input-telephone']
  //input[@id='input-password']
  //input[@id='input-confirm']
  //input[@name='agree']
  //input[@value='Continue']

  //h1[normalize-space()='Your Account Has Been Created!']
@FindBy(xpath="//input[@id='input-firstname']")WebElement firstname;
@FindBy(xpath="//input[@id='input-lastname']")WebElement lastname;
@FindBy(xpath="//input[@id='input-email']")WebElement email;
@FindBy(xpath="//input[@id='input-telephone']")WebElement telephone;
@FindBy(xpath="//input[@id='input-password']")WebElement userpwd;
@FindBy(xpath="//input[@id='input-confirm']")WebElement usercrfpwd;
@FindBy(xpath="//input[@name='agree']")WebElement policy;
@FindBy(xpath="//input[@value='Continue']")WebElement submitform;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgconfirmation;

public void userfname(String fname){
	firstname.sendKeys(fname);
}
public void userlname(String lname) {
	lastname.sendKeys(lname);
}
public void useremail(String mail) {
	email.sendKeys(mail);
}
public void usertelephone(String phone) {
	telephone.sendKeys(phone);
}
public void userpassword(String pwd) {
	userpwd.sendKeys(pwd);
}
public void usercrfpassword(String crfpwd) {
	usercrfpwd.sendKeys(crfpwd);
}
public void userpolicy() {
	policy.click();
}
public void formsubmit() {
	submitform.click();
}
public String verifymsg() {
	try{
		return(msgconfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}

}
  	
}	
	

