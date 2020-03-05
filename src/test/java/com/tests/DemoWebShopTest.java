package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.CheckOut;
import com.pages.DemoWebShopCellPhones;
import com.pages.DemoWebShopHome;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.utility.ExtentReport;

public class DemoWebShopTest {

	WebDriver driver;
	ExtentReport report =new ExtentReport();
	@BeforeClass
		public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + 
				"\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	@BeforeSuite
	public void createReport() {
	report.createReport();
	}
	
	
	@Test
	public void performRegistrationAndPlaceOrder() {
		HomePage hp=new HomePage(driver);
		hp.clickRegister();
		RegistrationPage rp=new RegistrationPage(driver);
		rp.performRegistration("Venkat", "Raman", "Venkat.raman@gmail.com", "Ven123", "Ven123");
		LoginPage lp=new LoginPage(driver);
		lp.enterCredentialsAndLogin("Venkat.raman@gmail.com", "Yash123");
		DemoWebShopHome home=new DemoWebShopHome(driver);
		home.validateAccountName("Venkat.raman@gmail.com");
		home.clickElectronicsAndCellPhone();
		DemoWebShopCellPhones cellPhone=new DemoWebShopCellPhones(driver);
		cellPhone.validateCellPhoneAndAddProduct();
		CheckOut checkout=new CheckOut(driver);
		checkout.enterBillingDetailsAndPlaceOrder();
	}
	@AfterClass
	public void quitBrowser() {
	driver.quit();
	}
}
