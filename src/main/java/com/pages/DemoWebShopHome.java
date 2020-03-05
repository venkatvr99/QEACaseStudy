package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DemoWebShopHome {
	
	
	public DemoWebShopHome(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='account']")
	WebElement accountName;
	
	public void validateAccountName(String emailId) {
		if(accountName.getText().equalsIgnoreCase(emailId)) {
			System.out.println("Email ID is matching successfully");
		}
			
	}
	@FindBy(xpath="//a[contains(text(),'Electronics')]")
	WebElement electronicsLink;
	
	@FindBy(xpath="//h2//a[contains(text(),'Cell phones')]")
	WebElement cellPhonesLink;
	
	public void clickElectronics() {
		electronicsLink.click();
		System.out.println("Electronics link is clicked successfully");
}
	public void clickCellPhones() {
		cellPhonesLink.click();
		System.out.println("Cell Phones link is clicked successfully");
}
	
	public void clickElectronicsAndCellPhone() {
		clickElectronics();
		clickCellPhones();
	}

}
