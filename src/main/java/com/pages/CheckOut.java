package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOut {

	public CheckOut(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
	WebElement countryDropDwn;

	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	WebElement billingCity;
	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	WebElement billingAddress1;
	@FindBy(xpath = "//input[@id='BillingNewAddress_Address2']")
	WebElement billingAddress2;
	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement zipCode;
	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement phoneNumber;

	public void enterBillingDetailsAndPlaceOrder() {
		billingCity.sendKeys("Coimbatore");
		billingAddress1.sendKeys("188/68, GiriNagar");
		billingAddress2.sendKeys("Perungalathur");
		zipCode.sendKeys("600063");
		phoneNumber.sendKeys("9000455645");
		selectcountryInCheckOut();
		continueBtn.click();

		clickContinueInShippingCart();
		clickContinueInShippingMethod();
		clickContinueInPayMentMethod();
		validatePayCODMsg();
		clickContinueInPaymentInfoPage();
		clickConfirmBtn();
		verifyOlderPlacedMsg();
		clickLogOut();
	}

	@FindBy(xpath = "//input[@class='button-1 new-address-next-step-button']")
	WebElement continueBtn;

	public void clickContinueInShippingCart() {
		continueBtninshippingCart.click();
	}

	public void clickContinueInShippingMethod() {
		continueInShippingMethod.click();
	}

	public void clickContinueInPayMentMethod() {
		continueInPaymentMethod.click();
	}

	public void validatePayCODMsg() {
		if (payByCOBMsg.isDisplayed()) {
			System.out.println("You will pay by COD message is displayed");
		}

	}

	public void clickContinueInPaymentInfoPage() {
		continueInPaymentInfoPage.click();
	}

	public void clickConfirmBtn() {
		confirmBtn.click();
	}

	public void verifyOlderPlacedMsg() {
		if (olderPlacedMsg.isDisplayed()) {
			System.out.println("Your order has been successfully processed! is displayed successfully");
		}
	}

	public void clickLogOut() {
		LogOutBtn.click();
	}

	@FindBy(xpath = "(//input[@class='button-1 new-address-next-step-button'])[2]")
	WebElement continueBtninshippingCart;

	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
	WebElement continueInShippingMethod;

	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
	WebElement continueInPaymentMethod;

	@FindBy(xpath = "//p[text()='You will pay by COD']")
	WebElement payByCOBMsg;

	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
	WebElement continueInPaymentInfoPage;

	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirmBtn;

	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	WebElement olderPlacedMsg;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement LogOutBtn;

	public void selectcountryInCheckOut() {
		Select select = new Select(countryDropDwn);
		select.selectByVisibleText("India");
	}
}
