package testacase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Homepage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.Baseclass;

public class TC_02Login extends Baseclass {
	@Test
	public void testLogin() throws InterruptedException {
	   Homepage hp=new Homepage(driver);
	   hp.ClickMyAccount();
	   hp.clickOnLogin();
	   
	   LoginPage lp=new LoginPage(driver);
	   lp.sendEmail("mnp1506@gmail.com"); //  emailwill get from config file
	   lp.sendPassword("12345a");  // password will get from config file
	   Thread.sleep(3000);
	   lp.clickOnLogin();
	   
	   MyAccountPage ma=new MyAccountPage(driver);
	  boolean target= ma.isMyAccountExists();
	   Assert.assertEquals(target, true);
	   logger.info("Finished TC_02Login");
	
	
		
		
	}

}
