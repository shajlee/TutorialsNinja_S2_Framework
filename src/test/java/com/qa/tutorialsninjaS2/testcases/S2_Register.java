package com.qa.tutorialsninjaS2.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.tutorialsninjaS2.pages.S2_Register_Page;
import com.qa.tutorialsninjaS2.testbase.Tutorials_Ninja_S2_TestBase;

public class S2_Register extends Tutorials_Ninja_S2_TestBase {
	public S2_Register() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeAndOpenBrowser(prop.getProperty("browserName1"));
	}
	@Test
	public void registerWithRequiredFields() {
		S2_Register_Page RegisterRequired = new S2_Register_Page(driver);
		RegisterRequired.clickOnMyAccountLink();
		RegisterRequired.clickOnRegisterLink();
		RegisterRequired.enterFirstName(prop.getProperty("firstName"));
		RegisterRequired.enterLastName(prop.getProperty("lastName"));
		RegisterRequired.enterEmail(prop.getProperty("registrationEmail"));
		RegisterRequired.enterTelephoneNumber(prop.getProperty("registrationPhoneNumber"));
		RegisterRequired.enterPassword(prop.getProperty("registrationPassword"));
		RegisterRequired.enterPasswordConfirmation(prop.getProperty("registrationPassword"));
		RegisterRequired.clickOnPrivacyPolicy();
		RegisterRequired.clickOnContinueButton();
		WebElement accountCreationMessage = RegisterRequired.accountCreationDisplayMessage(); 
		softassert.assertTrue(accountCreationMessage.isDisplayed(), "Account Creation Message is not displayed.");
		softassert.assertAll();
	}
	@Test
	public void registerWithAllFields() {
		S2_Register_Page RegisterRequired = new S2_Register_Page(driver);
		RegisterRequired.clickOnMyAccountLink();
		RegisterRequired.clickOnRegisterLink();
		RegisterRequired.enterFirstName(prop.getProperty("firstName"));
		RegisterRequired.enterLastName(prop.getProperty("lastName"));
		RegisterRequired.enterEmail(prop.getProperty("registrationEmail"));
		RegisterRequired.enterTelephoneNumber(prop.getProperty("registrationPhoneNumber"));
		RegisterRequired.enterPassword(prop.getProperty("registrationPassword"));
		RegisterRequired.enterPasswordConfirmation(prop.getProperty("registrationPassword"));
		List<WebElement>newsLetterRadioButton = RegisterRequired.newsLetterRadioButton; 
		for(int i=0;i<newsLetterRadioButton.size(); i++) {
			if(newsLetterRadioButton.get(i).getAttribute("value").equalsIgnoreCase("1"));
			newsLetterRadioButton.get(i).click();
			break;
		}
		RegisterRequired.clickOnPrivacyPolicy();
		RegisterRequired.clickOnContinueButton();
		
		WebElement accountCreationMessage = RegisterRequired.accountCreationDisplayMessage(); 
			softassert.assertTrue(accountCreationMessage.isDisplayed(), "Account Creation Message is not displayed.");
			softassert.assertAll();
	}
	@Test
	public void registerWithNoFields() {
		S2_Register_Page RegisterRequired = new S2_Register_Page(driver);
		RegisterRequired.clickOnMyAccountLink();
		RegisterRequired.clickOnRegisterLink();
		RegisterRequired.clickOnContinueButton();
		
		WebElement PrivacyPolicyMessage = RegisterRequired.privacyPolicyDisplayMessage(); 
		softassert.assertTrue(PrivacyPolicyMessage.isDisplayed(), "PrivacyPolicyMessage is not displayed");
		softassert.assertAll();
		
		WebElement FirstNameMessage = RegisterRequired.firstNameDisplayMessage(); 
		softassert.assertTrue(FirstNameMessage.isDisplayed(), "FirstNameMessage is not displayed");
		softassert.assertAll();
		
		WebElement LastNameMessage = RegisterRequired.lastNameDisplayMessage(); 
		softassert.assertTrue(LastNameMessage.isDisplayed(), "LastNameMessage is not displayed");
		softassert.assertAll();
		
		WebElement EmailMessage = RegisterRequired.emailDisplayMessage(); 
		softassert.assertTrue(EmailMessage.isDisplayed(), "EmailMessage is not displayed");
		softassert.assertAll();
		
		WebElement TelephoneMessage = RegisterRequired.telephoneDisplayMessage(); 
		softassert.assertTrue(TelephoneMessage.isDisplayed(), "TelephoneMessage is  not displayed");
		softassert.assertAll();
		
		WebElement PasswordMessage = RegisterRequired.passwordDisplayMessage(); 
		softassert.assertTrue(PasswordMessage.isDisplayed(), "PasswordMessage is  not displayed");
		softassert.assertAll();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();

		
			
		}
		
	
		
		
	}


