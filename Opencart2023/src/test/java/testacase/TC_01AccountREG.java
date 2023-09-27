package testacase;


import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationpage;
import PageObject.Homepage;
import testBase.Baseclass;


public class TC_01AccountREG extends Baseclass{
	
	  @Test
		public void test_account_Registration() throws InterruptedException
		{
		  logger.info("***  Starting TC_001_AccountRegistrationTest ***");
			try {
			Homepage hp=new Homepage(driver);
			hp.ClickMyAccount();
			logger.info("Clicked on My account link");
		    hp.ClickRegister();
		    logger.info("Clicked on register link");
			
			
			AccountRegistrationpage regpage=new AccountRegistrationpage(driver);
			logger.info("Providing customer data");
		
			
			regpage.sendFirstName(randomeString().toUpperCase());
			
			regpage.sendLastName(randomeString().toUpperCase());
			
			//regpage.sendEmail(randomeString()+"@gmail.com");// randomly generated the email
			
			
			
			String password=randomAlphaNumeric();
			regpage.sendPasword(password);
			regpage.scrollpage();
			
			Thread.sleep(3000);
			regpage.selectAgree();
			Thread.sleep(3000);
			
			regpage.ClickContinue();
			logger.info("Clicked on continue");
			Thread.sleep(3000);
	
			
			String confmsg=regpage.teXtVerify();
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			}
			catch(Exception e) {
				
				Assert.fail();
			}
			logger.info("***  Finished TC_001_AccountRegistrationTest ***");
			
		}
	}



