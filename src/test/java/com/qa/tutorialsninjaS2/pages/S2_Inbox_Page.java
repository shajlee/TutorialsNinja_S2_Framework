package com.qa.tutorialsninjaS2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Inbox_Page {
	public WebDriver driver;
	
	@FindBy(xpath = "//span[text() = 'My Account']")
	private WebElement myAccountLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(css = "input#input-email")
	private WebElement usernameTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement signInButton;
	
	@FindBy(xpath = "//div[@class='list-group']/child::a[1]")
	private WebElement myAccountDisplayMessage;
	
	public S2_Inbox_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterUserName(String userNameText) {
		usernameTextBox.sendKeys(userNameText);
	}
	public void enterPassWord(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public WebElement myAccountDisplay() {
		return myAccountDisplayMessage;
	}
	//public boolean MyAccountMessageIsDisplayed() {
		//boolean displayStatus = myAccountDisplayMessage.isDisplayed();
		//return displayStatus;
		
		
	}
	
	
	
	
	


