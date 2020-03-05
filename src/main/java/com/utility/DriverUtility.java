package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

public class DriverUtility {
	
	WebDriver driver;
	@BeforeSuite
	public void launchBrowser(String browser) {
		
	
	if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
	}
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
	}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
	}

}
}
