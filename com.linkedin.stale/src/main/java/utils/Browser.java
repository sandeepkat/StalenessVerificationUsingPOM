package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import edu.emory.mathcs.backport.java.util.Collections;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends Global{
	private static Browser browser;
	private static WebDriver driver;
	
	// To get browser instance
	public static Browser getBrowser() {
		return browser;
	}
	
	// To set browser instance
	public static void setBrowser(Browser browser) {
		Browser.browser = browser;
	}
	
	// To set driver instance
	public void setDriver(WebDriver driver) {
		Browser.driver = driver;
		Browser.driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//To quit driver instance
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	/*
	 * This method will return the driver if exists else by default returns chrome Driver
	 * 
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			setBrowser(new Browser(Global.CHROME));
			driver.manage ().timeouts().pageLoadTimeout(Global.DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
		
		return driver;
	}

	public Browser(String browserType) {
		
		switch (browserType) {
		case Global.CHROME:
			WebDriverManager.chromedriver().setup();
	        //System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("start-maximized");
	        options.setExperimentalOption("useAutomationExtension", false);
	        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			this.setDriver(new ChromeDriver(options));
			break;	
		case Global.INTERNET_EXPLORER:
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions optionsIE = new InternetExplorerOptions();
			optionsIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			this.setDriver(new InternetExplorerDriver(optionsIE));
			break;
		case Global.FIREFOX:			
			WebDriverManager.firefoxdriver().setup();
			this.setDriver(new FirefoxDriver());
			break;
		case "":
			return;
		}
	}
	
	public static void open(String url) throws TimeoutException {
		getDriver().get(url);	
	}

	/*
	 * This method gives time for the browser to sleep
	 * 
	 */
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
