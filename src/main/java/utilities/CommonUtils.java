package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	public WebDriver driver;
	long minTime = 60;
	public CommonUtils(WebDriver driver)
	{
		this.driver = driver;		
	}
	/**
	 * Method to Click the WebElement
	 */
	public void click(WebElement element) 
	{
		waitTillElementIsClickable(element, minTime);
		 element.click();
	}
	/**
	 * Method to wait till the Element is Clickable
	 */
	public void waitTillElementIsClickable(WebElement element, long time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time); //new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(element)));
		
	}
	
	public void waitTillElementIsVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time); //new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(element)));
		
	}
	
	public void scrollToWebElement(WebElement element) throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element); 
	}
	
	public void clickByJE(WebElement element) throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element); 
	}

}
