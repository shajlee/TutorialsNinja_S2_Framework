package com.qa.tutorialsninjaS2.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Register_Page {
	public WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountLink;
	
	@FindBy(linkText = "Register")
	public WebElement registerLink;
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	public WebElement firstNameTextBox;
	
	@FindBy(css = "input#input-lastname")
	public WebElement lastNameTextBox;
	
	@FindBy(id = "input-email")
	public WebElement emailTextBox;
	
	@FindBy(name = "telephone")
	public WebElement telephoneTextBox;
	
	@FindBy(css = "input#input-password")
	public WebElement passwordTextBox;
	
	@FindBy(css = "input#input-confirm")
	public WebElement passwordConfirmationTextBox;
	
	@FindBy(name = "agree")
	public WebElement privacyPolicy;
	
	@FindBy(css = "input.btn.btn-primary")
	public WebElement continueButton;
	
	@FindBy(css = "div#content h1")
	public WebElement accountCreationMessage;
	
	@FindBy(css = "label.radio-inline input")
	public List <WebElement> newsLetterRadioButton;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement privacyPolicyMessage;
	
	@FindBy(css = "input#input-firstname+div")
	private WebElement firstNameMessage;
	
	@FindBy(css = "input#input-lastname+div")
	private WebElement lastNameMessage;
	
	@FindBy(css = "input#input-email+div")
	private WebElement emailMessage;
	
	@FindBy(css = "input#input-telephone+div")
	private WebElement telephoneMessage;
	
	@FindBy(css = "input#input-password+div")
	private WebElement passwordMessage;
	
	public S2_Register_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}
	public void clickOnRegisterLink() {
		registerLink.click();
	}
	public void enterFirstName(String firstnameText) {
		firstNameTextBox.sendKeys(firstnameText);
	}
	public void enterLastName(String lastnameText) {
		lastNameTextBox.sendKeys(lastnameText);
	}
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	public void enterTelephoneNumber(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void enterPasswordConfirmation(String passwordText) {
		passwordConfirmationTextBox.sendKeys(passwordText);
	}
	public void clickOnPrivacyPolicy() {
		privacyPolicy.click();
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public WebElement accountCreationDisplayMessage() {
		return accountCreationMessage;
	}
	public List <WebElement> newsletterRadioButton() {
		return newsLetterRadioButton;
	}
	public WebElement privacyPolicyDisplayMessage() {
		return privacyPolicyMessage;
	}
	public WebElement firstNameDisplayMessage() {
		return firstNameMessage;
	}
	public WebElement lastNameDisplayMessage() {
		return lastNameMessage;
	}
	public WebElement emailDisplayMessage() {
		return emailMessage;
	}
	public WebElement telephoneDisplayMessage() {
		return telephoneMessage;
	}
	public WebElement passwordDisplayMessage() {
		return passwordMessage;
		
		
	}
	
		
		
		
		
		
		
		
	
		
		
	}


