package testBase;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
   @BeforeClass
   @Parameters("Browser")  // xml file  chrome br=chrome
	public void setUp(String br) throws InterruptedException
	{

		rb=ResourceBundle.getBundle("config");//property file
		
	    logger=LogManager.getLogger(this.getClass()); //get the log(activity) of the current testcase
	   
	    if (br.equals("chrome")) {
			driver = new ChromeDriver(); // to execute chromedriver
		} else if (br.equals("edge")) {
			driver = new EdgeDriver(); // to execute msedge driver
		} else {
			driver = new ChromeDriver();
		}
		
	
		
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));// url
				
		driver.manage().window().maximize();
		  Thread.sleep(3000);
	}
	
   @AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);//abcde, tyuio, nhjio,
		return (generatedString);
	}

	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);//abcd, mnjh,
		String num = RandomStringUtils.randomNumeric(3); //123,456.678,
		
		return (st+"@"+num);   //password
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
		

	}


