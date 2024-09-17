package com.qa.tutorialsninjaS2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Search_Page {
	public WebDriver driver;
	
	@FindBy(css = "input.form-control.input-lg")
	private WebElement ProductSearchBox;
	
	@FindBy(xpath = "//span[@class = 'input-group-btn']/child::button")
	private WebElement searchButton;
	
	@FindBy(linkText = "MacBook")
	private WebElement validProduct;
	
	@FindBy(css = "input#button-search+h2+p")
	private WebElement invalidProduct;
	
	public S2_Search_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterProduct(String validProductText) {
		ProductSearchBox.sendKeys(validProductText);
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public WebElement validProductIsDisplayed() {
		return validProduct;
	}
	public WebElement invalidProductIsDisplayMessage() {
		return invalidProduct;
	}

}
