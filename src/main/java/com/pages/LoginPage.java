package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailIdField;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement pwdField;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginBtn;

	public void enterEmailID(String emailID) {
		emailIdField.sendKeys(emailID);
		System.out.println("Email ID entered successfully");
	}

	public void enterPassword(String pwd) {
		pwdField.sendKeys(pwd);
		System.out.println("Password entered successfully");
	}

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement LoginInHeader;

	public void clickLogin() {
		LoginInHeader.click();
	}

	public void clickLoginBtn() {
		loginBtn.click();
		System.out.println("Login clicked successfully");
	}

	public void enterCredentialsAndLogin(String userName, String password) {
		clickLogin();
		enterEmailID(userName);
		enterPassword(password);
		clickLoginBtn();
	}

}
