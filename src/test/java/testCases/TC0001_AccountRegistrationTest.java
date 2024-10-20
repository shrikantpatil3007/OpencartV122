package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseClass;
import pageObjects.Account_RegistrationPage;
import pageObjects.HomePage;

	public class TC0001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void User_Account_Registration_Process() {
		logger.info("***Log Started TC0001_AccountRegistrationTest***");
		try {
		HomePage hp = new HomePage(driver);
		hp.Accountclicked();
		logger.info("Clicked to MyAccount...");
		hp.registerclicked();
		logger.info("Clicked to Register...");
		Account_RegistrationPage accreg = new Account_RegistrationPage(driver);
		logger.info("Entered Registration details..");
		accreg.userfname(randomalphabet());
		accreg.userlname(randomalphabet());
		accreg.useremail(randomalphabet()+"@gmail.com");
		accreg.usertelephone(randomnumber());
		String password = randomalphanumber();
		accreg.userpassword(password);
		accreg.usercrfpassword(password);
		accreg.userpolicy();
		accreg.formsubmit();
		logger.info("Verifying Expected Message..");
		String confirmmsg = accreg.verifymsg();
		if(confirmmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed..");
		    logger.debug("Debug logs...");
		    Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Log Finished TC0001_AccountRegistrationTest***");
	}
		
		
	}
