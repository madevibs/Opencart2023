package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends BasePage{
	
	
	public AccountRegistrationpage (WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Agree;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continueok;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Textverify;
	
	public void sendFirstName(String fname)
			 {
		firstname.sendKeys(fname);
		
	}
	public void sendLastName(String lname) {
		LastName.sendKeys(lname);
	}
	public void sendEmail(String email )
	{
		Email.sendKeys(email);
	}
	public void sendPasword(String pw) {
	password.sendKeys(pw);
	}
	public void selectAgree() {
		Agree.click();
	}
	public void ClickContinue() {
		continueok.click();
	}
	public String teXtVerify()
	{
		try {
		return(driver.getTitle());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	public void scrollpage(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 350)","");
		
		
	}
			
		
	}


