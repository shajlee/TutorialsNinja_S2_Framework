package com.qa.tutorialsninjaS2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Login_Page {
	public WebDriver driver;
	
	@FindBy(xpath = "//span[text() = 'My Account']")
	public WebElement myAccountLink;
	
	@FindBy(linkText = "Login")
	public WebElement loginLink;
	
	@FindBy(css = "input#input-email")
	public WebElement userNameTextBox;
	
	@FindBy(name = "password")
	public WebElement passwordTextBox;
	
	@FindBy(css = "input.btn.btn-primary")
	public WebElement signInButton;
	
	@FindBy(xpath = "//div[@class='list-group']/child::a[1]")
	public WebElement myAccountDisplay;
	
	@FindBy(xpath = "//div[@id='account-login']/child::ul/following-sibling::div[1]")
	public WebElement invalidCredentialsMessage;
	
	@FindBy(xpath = "//div[@id='account-login']/child::ul/following-sibling::div[1]")
	public WebElement invalidPasswordMessage;
	
	@FindBy(xpath = "//div[@id='account-login']/child::ul/following-sibling::div[1]")
	public WebElement invalidUsernameMessage;
	
	@FindBy(xpath = "//div[@id='account-login']/child::ul/following-sibling::div[1]")
	public WebElement noCredentialsMessage;
	
	public S2_Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterUserName(String usernameText) {
		userNameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public WebElement myAccountDisplayMessage() {
		return myAccountDisplay;
	}
	public WebElement invalidCredentialsDisplayMessage() {
		return invalidCredentialsMessage;
	}
	public WebElement invalidPasswordDisplayMessage() {
		return invalidPasswordMessage;
	}
	public WebElement invalidUsernameDisplayMessage() {
		return invalidUsernameMessage;
	}
	public WebElement noCredentialsDisplayMessage() {
		return noCredentialsMessage;
	}
	
	
	
	

}
