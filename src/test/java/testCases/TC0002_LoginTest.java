package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC0002_LoginTest extends BaseClass {
	@Test(groups = {"Sanity","Master"})
	public void verify_login() {
		logger.info("***Starting TC0002_LoginTest***");
		try {
			//Homepage
		HomePage hp = new HomePage(driver);
			hp.Accountclicked();
			hp.loginclicked();
			//LoginPage
		LoginPage lp = new LoginPage(driver);
			lp.useremail(p.getProperty("MAIL"));
			lp.userpwd(p.getProperty("PASSWORD"));
			lp.submitting();
			//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		    boolean Targetpage = macc.verifymyacc();
		    Assert.assertTrue(Targetpage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC0002_LoginTest***");
		 
	}
	
	
	

}
