package testacase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Homepage;

import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.Baseclass;

import utilities.DataProviders;

public class TC_LoginDataDrivenTest extends Baseclass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			Homepage hp = new Homepage(driver);
			hp.ClickMyAccount();
			hp.clickOnLogin();

			LoginPage lp = new LoginPage(driver);
			lp.sendEmail(email);
			lp.sendPassword(pwd);
			lp.clickOnLogin();

			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					macc.clickOnLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					
			       macc.clickOnLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}
}



