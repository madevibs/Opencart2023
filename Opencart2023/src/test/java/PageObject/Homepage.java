package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage{
	
	public Homepage(WebDriver driver) {
		
		super(driver);
	}
		
		@FindBy(xpath ="//span[text()='My Account']")
		WebElement linkaccount;
		
		@FindBy(xpath= "//a[normalize-space()='Register']")
		WebElement linkRegister;
		
		@FindBy(xpath="//a[normalize-space()='Login']")
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
	


