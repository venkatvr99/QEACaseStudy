package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RegistrationPage {

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-male")
	WebElement maleRadioBtn;

	@FindBy(id = "gender-female")
	WebElement femaleRadioBtn;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailID;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement regiterBtn;

	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	WebElement regCompletedMsg;

	public void clickMaleRadioBtn() {
		maleRadioBtn.click();
		System.out.println("Male radio button clicked successfully");

	}

	public void clickFemaleRadioBtn() {
		femaleRadioBtn.click();
		System.out.println("Female radio button clicked successfully");

	}

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
		System.out.println("First name entered successfully");
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
		System.out.println("Last name entered successfully");
	}

	public void enterEmailId(String email) {
		emailID.sendKeys(email);
		System.out.println("Email ID entered successfully");
	}

	public void enterPwd(String pwd) {
		password.sendKeys(pwd);
		System.out.println("Password entered successfully");
	}

	public void enterConfirmPwd(String confirmPwd) {
		confirmPassword.sendKeys(confirmPwd);
		System.out.println("ConfirmPassword entered successfully");
	}

	public void clickRegister() {
		regiterBtn.click();
		System.out.println("Register entered successfully");
	}

	
	public void performRegistration(String firstname, String lastname, String email, String pwd, String confirmPwd) {
		clickMaleRadioBtn();
		enterFirstName(firstname);
		enterLastName(lastname);
		enterEmailId(email);
		enterPwd(pwd);
		enterConfirmPwd(confirmPwd);
		clickRegister();
		verifyRegistrationCompletedMsgIsDisplayed();
		clickLogOut();
	}

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement LogOutBtn;

	public void clickLogOut() {
		LogOutBtn.click();
	}

	public void verifyRegistrationCompletedMsgIsDisplayed() {
		if (regCompletedMsg.isDisplayed()) {
			System.out.println("Your registration completed message is displayed");
		} else {
			System.out.println("Your registration completed message is not displayed");
		}

	}

}
