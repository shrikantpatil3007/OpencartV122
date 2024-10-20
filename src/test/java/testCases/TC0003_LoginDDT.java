package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC0003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class,groups="dataDriven")
	public void verify_loginDDT(String mail,String pwd,String exp) throws InterruptedException {
		logger.info("***Started TC0003_LoginDDT***");
		try {
		//Homepage
		HomePage hp = new HomePage(driver);
			hp.Accountclicked();
			hp.loginclicked();
			//LoginPage
		LoginPage lp = new LoginPage(driver);
			lp.useremail(mail);
			lp.userpwd(pwd);
			lp.submitting();
			//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		    boolean Targetpage = macc.verifymyacc();
		   
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(Targetpage==true) 
			{
				macc.clkdlogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(Targetpage==true) 
			{
				macc.clkdlogout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("***Finished TC0003_LoginDDT***");
		
		
		
		
	}

}
