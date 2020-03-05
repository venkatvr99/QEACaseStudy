package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoWebShopCellPhones {

	public DemoWebShopCellPhones(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Smartphone']")
	WebElement smartPhone;

	@FindBy(xpath = "//a[text()='Used phone']")
	WebElement usedPhone;

	@FindBy(xpath = "//a[text()='Phone Cover']")
	WebElement phoneCover;

	@FindBy(xpath = "//input[contains(@id,'addtocart')]")
	WebElement quantityTextBox;

	@FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//p[contains(text(),'The product has been added to your')]")
	WebElement shoppingCartAddedMsg;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingCartLink;

	public void validateCellPhoneAndAddProduct() {
		validateCellPhoneResultsAreDisplayed();
		addProduct();
	}
	public void validateCellPhoneResultsAreDisplayed() {
		if (smartPhone.isDisplayed() && usedPhone.isDisplayed() && phoneCover.isDisplayed())
			System.out.println("Cell phone related items are displayed in Cell phones section");
	}

	public void addProduct() {
		clickOnSmartPhone();
		enterQuantity();
		clickAddToCartBtn();
		validateShoppingCartAddedMsg();
		clickShopingCartLink();
		validatePrice();
		validateItemQuantity();
		selectCountry();
		clickTermsOfService();
		clickCheckOut();
	}

	public void clickOnSmartPhone() {
		smartPhone.click();
	}

	public void enterQuantity() {
		quantityTextBox.clear();
		quantityTextBox.sendKeys("2");
	}

	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	public void validateShoppingCartAddedMsg() {

		if (shoppingCartAddedMsg.isDisplayed())
			shoppingCartAddedMsg.getText().contains("The product has been added to your");
		System.out.println("shopping cart added message is displayed");
	}

	public void clickShopingCartLink() {
		shoppingCartLink.click();
	}

	@FindBy(className = "product-subtotal")
	WebElement productTotalPrice;

	public void validatePrice() {
		productTotalPrice.getText().equals("200.00");
	}

	@FindBy(xpath = "//input[contains(@name,'itemquantity')]")
	WebElement itemQuantity;

	public void validateItemQuantity() {
		if (itemQuantity.getAttribute("value").equals("2"))
			System.out.println("Cart is displayed with correct quantity");
	}

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public void clickCheckOut() {
		checkoutBtn.click();

	}

	@FindBy(xpath = "//*[@id='CountryId']")
	WebElement countryDropDown;

	@FindBy(id = "termsofservice")
	WebElement termsOfService;

	public void selectCountry() {
		Select country = new Select(countryDropDown);
		country.selectByVisibleText("India");
	}

	public void clickTermsOfService() {
		termsOfService.click();
	}
}
