package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement loginLink;
	
	
	
	public void clickRegister() {
	registerLink.click();
	System.out.println("Register link is clicked successfully");
	}
	
	
	
}
