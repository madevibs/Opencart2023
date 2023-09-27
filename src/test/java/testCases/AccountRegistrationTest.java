
package testCases;



import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.Homepage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {


	@Test
	public void test_account_Registration() throws InterruptedException
	{
	try {
		     logger.info("***  Starting AccountRegistrationTest ***");
			
		
			Homepage hp=new Homepage(driver);
			hp.ClickMyAccount();
			logger.info("Clicked on My account link"); 
		    hp.ClickRegister();
		    logger.info("Clicked on register link");
		   
		    Thread.sleep(3000);
		  
			
			
			RegistrationPage regpage=new RegistrationPage(driver);
			Thread.sleep(3000);
			logger.info("Providing customer data");
			
		
			                      //abcde  --->ABCDE
			regpage.sendFirstName(randomeString().toUpperCase());  //random string inputs
			Thread.sleep(3000);
			
			regpage.sendLastName(randomeString().toUpperCase());
			Thread.sleep(3000);
			
			//regpage.sendEmail(randomeString()+"@gmail.com");// randomly generated the email
			Thread.sleep(3000);
			
		
			
			String password=randomAlphaNumeric();
			regpage.sendPasword(password);
			//regpage.setConfirmPassword(password);
			Thread.sleep(3000);
			
			regpage.selectAgree();
			Thread.sleep(3000);
			
			regpage.ClickContinue();
			Thread.sleep(5000);
			logger.info("Clicked on continue");
			

			
			String confmsg=regpage.teXtVerify();
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			}
	 catch (Exception e) {
		// TODO Auto-generated catch block
			logger.error("test failed");
		e.printStackTrace();
	}
	logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	
	}
	
		
		
	
		
		
	}


	
	


