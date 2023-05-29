package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverManager {
	public WebDriver driver; // reference variable for web driver class.class should be capital
	static DesiredCapabilities capabilities; //
	String driverPath = File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+ "driver" + File.separator; // src/main/resources/driver. based on OS.

	public String getDriverPath() { // getter method
		return driverPath;
	}

	public void setDriver(WebDriver driver) { // setter method
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Method to Set Driver Path based on the Browser Name.
	 */
	public void setDriverPath(String browserName) {
		switch (browserName) {
		case "Chrome":
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				this.driverPath = driverPath + "mac" + File.separator + "chromedriver";
			} else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				this.driverPath = driverPath + "windows" + File.separator + "chromedriver.exe";
			} else {
				this.driverPath = driverPath + "ubuntu" + File.separator + "chromedriver";
			}
			break;
		case "Firefox":
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				this.driverPath = driverPath + "geckodriver";
			} else {
				this.driverPath = driverPath + "geckodriver.exe";
			}
			break;
		
		}

	}
       // intializing  new browser or craeting new browser.
	public void initializeDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			setDriverPath("Chrome");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + getDriverPath());
			setDriver(new ChromeDriver());
			break;
		case "Firefox":
			setDriverPath("Firefox");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + getDriverPath());
			setDriver(new FirefoxDriver());
			break;
		
		default:
			System.out.println("Initializing Chrome Browser by Default");
			setDriverPath("Chrome");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + getDriverPath());
			setDriver(new ChromeDriver());
			break;
		}

	}

	public void goToHome(String url) throws Exception {
		driver.get(url);
	}
}
