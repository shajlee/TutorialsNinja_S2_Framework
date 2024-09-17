package com.qa.tutorialsninjaS2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Logout_Page {
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
	
	@FindBy(linkText = "Logout")
	public WebElement logoutButton;
	
	@FindBy(css = "div#content h1+p")
	public WebElement logoutMessage;
	
	public S2_Logout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterUsername(String usernameText) {
		userNameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSigninButton() {
		signInButton.click();
	}
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	public WebElement logoutDisplayMessage() {
		return logoutMessage;
		
	}

}
