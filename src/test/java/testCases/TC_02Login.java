package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02Login extends BaseClass {
	@Test()
	public void testLogin() throws InterruptedException {
		
	   Homepage hp=new Homepage(driver);
	   
	   hp.ClickMyAccount();
	   hp.clickOnLogin();
	   
	   LoginPage lp=new LoginPage(driver);
	   
	   //get the values from excel file and pass it 
	   
	   lp.sendEmail(rb.getString("email")); //  email will get from config file
	   lp.sendPassword(rb.getString("password"));  // password will get from config file
	   Thread.sleep(3000);
	   lp.clickOnLogin();
	   Thread.sleep(3000);
	   
	   MyAccountPage ma=new MyAccountPage(driver);
	   
	  boolean target= ma.isMyAccountExists();
	   Assert.assertEquals(target, true);
	   logger.info("Finished TC_02Login");
	
	
		
		
	}

}
