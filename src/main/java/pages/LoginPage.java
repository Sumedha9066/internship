package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.implementation.bind.annotation.This;
import utilities.CommonUtils;

public class LoginPage extends CommonUtils {
	public WebDriver driver;
	int mintime=60;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(id = "txtUsername")
	WebElement loginusernametext;
	
	@FindBy(id="txtPassword")
	WebElement loginpasswordtext;
	
	@FindBy(xpath = "//*[@id=\"frmLogin\"]/div[4]/button")
	WebElement loginbuttonclicking;
	
	
	public void enterusername(String username)
	{
		waitTillElementIsVisible(loginusernametext,mintime);
		loginusernametext.clear();
		loginusernametext.sendKeys("Admin");
	}

	public void enterpassword(String password)
	{
		waitTillElementIsVisible(loginpasswordtext, mintime);
		loginpasswordtext.clear();
		loginpasswordtext.sendKeys("Upe@F6MI8r");
		
	}
     
	public void clickingloginbutton() {
		waitTillElementIsClickable(loginbuttonclicking, mintime);
		loginbuttonclicking.click();
		
	}
	
	
     
}
