package login;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import helper.LoginHelper;
import utilities.WebdriverManager;

public class Logintests {

	SoftAssert softAssert;
	public WebDriver driver;
	String loginUrl = "https://amit0008-trials79.orangehrmlive.com/";
	
	LoginHelper loginHelper; 
	
	
	@BeforeClass(alwaysRun = true) 
	public void setUp() {
		softAssert=new SoftAssert();
		WebdriverManager webdriverManager = new WebdriverManager();
		webdriverManager.initializeDriver("chrome");
		driver = webdriverManager.getDriver();
		
		
		loginHelper = new LoginHelper(driver);
		driver.get(loginUrl);
	}
	
	
	@Test(description="verify login page of orangehrm application",groups= {"smoke_test"},testName="Login-1.1")
	public void loginToOrangeHRM() throws InterruptedException {
	 loginHelper.loginHelper("Admin","Upe@F6MI8r"); 
	 Thread.sleep(5000);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
