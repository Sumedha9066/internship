package helper;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import utilities.CommonUtils;
import utilities.WebdriverManager;

public class LoginHelper {
	LoginPage loginPage;
	CommonUtils commonUtils;
	WebdriverManager webdriverManager;
	
	public LoginHelper(WebDriver driver) {
		loginPage=new LoginPage(driver);
		commonUtils = new CommonUtils(driver);
	    webdriverManager = new WebdriverManager();
	 
	}
	
	public void loginHelper(String username, String password) {
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.clickingloginbutton();
	}

}
