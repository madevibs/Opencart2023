package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage{
	
	public Homepage(WebDriver driver) {
		
		super(driver);
	}
	
		
		@FindBy(xpath="//span[text()='My Account']")//this is for my account option
		WebElement linkaccount;
		
		@FindBy(xpath="//a[normalize-space()='Register']")// this is for register option
		WebElement linkRegister;
		
		@FindBy(xpath="//a[normalize-space()='Login']")//this is for login option
		WebElement login;
		
		public void ClickMyAccount() {
			linkaccount.click();
		}
		public void ClickRegister() {
			linkRegister.click();
			
		}
		public void clickOnLogin()
		{
			login.click();		}
		
	}


