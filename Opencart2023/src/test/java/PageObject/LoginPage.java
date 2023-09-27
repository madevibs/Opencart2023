package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
	
		super(driver);
	}
		
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement email;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement password;
		
		@FindBy(xpath="//button[normalize-space()='Login']")
		WebElement loginButton;
		
		public void sendEmail(String email1) {
			email.sendKeys(email1);
	}
		public void sendPassword(String pw) {
			password.sendKeys(pw);
		}
		public void clickOnLogin()
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", loginButton);
		}
	

}
