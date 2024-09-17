package com.qa.tutorialsninjaS2.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.tutorialsninjaS2.pages.S2_Login_Page;
import com.qa.tutorialsninjaS2.tesdata.S2_TestDataSupply;
import com.qa.tutorialsninjaS2.testbase.Tutorials_Ninja_S2_TestBase;
import com.qa.tutorialsninjaS2.utilities.TutorialsNinja_S2_Utilities;

public class S2_Login extends Tutorials_Ninja_S2_TestBase{
	public S2_Login() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeAndOpenBrowser(prop.getProperty("browserName1"));
	}
	@Test(priority = 1, dataProvider = "TutorialsNinja_S2_DataProvider_DataSupply", dataProviderClass = S2_TestDataSupply.class)
	public void loginWithValidCredentialsUsingDataProvider(String username, String password) {
		S2_Login_Page login = new S2_Login_Page(driver);
		login.clickOnMyAccountLink();
		login.clickOnLoginLink();
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnSignInButton();
		WebElement myAccoutnDisplay = login.myAccountDisplayMessage(); 
		softassert.assertTrue(myAccoutnDisplay.isDisplayed(), "My Account Button is not displayed");
		softassert.assertAll();
	}
	@Test(priority = 2, dataProvider = "TutorialsNinja_S1_ExcelSheet_DataSupply", dataProviderClass = S2_TestDataSupply.class)
	public void loginWithValidCredentialsUsingExcelSheet(String username, String password) {
		S2_Login_Page login = new S2_Login_Page(driver);
		login.clickOnMyAccountLink();
		login.clickOnLoginLink();
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnSignInButton();
		WebElement myAccoutnDisplay = login.myAccountDisplayMessage(); 
		softassert.assertTrue(myAccoutnDisplay.isDisplayed(), "My Account Button is not displayed");
		softassert.assertAll();
	}
	@Test(priority = 3)
	public void loginWithInvalidCredentials() {
		S2_Login_Page login = new S2_Login_Page(driver);
		login.clickOnMyAccountLink();
		login.clickOnLoginLink();
		login.enterUserName(TutorialsNinja_S2_Utilities.generateEmailWithTimeStamp());
		login.enterPassword(TutorialsNinja_S2_Utilities.generatePasswordWithTimeStamp());
		login.clickOnSignInButton();
		WebElement invalidCredentialsMessage = login.invalidCredentialsDisplayMessage(); 
		softassert.assertTrue(invalidCredentialsMessage.isDisplayed(), "Invalid Credentials Message is not displayed");
		softassert.assertAll();
	}
	@Test(priority = 4)
	public void loginWithValidUsernameInvalidPassword() {
		S2_Login_Page login = new S2_Login_Page(driver);
		login.clickOnMyAccountLink();
		login.clickOnLoginLink();
		login.enterUserName(prop.getProperty("validEmail"));
		login.enterPassword(TutorialsNinja_S2_Utilities.generatePasswordWithTimeStamp());
		login.clickOnSignInButton();
		WebElement invalidPasswordMessage = login.invalidUsernameDisplayMessage(); 
		softassert.assertTrue(invalidPasswordMessage.isDisplayed(), "Invalid Credentials Message is not displayed");
		softassert.assertAll();
	}
	@Test(priority = 5)
	public void loginwithInvalidUsernameValidPassword() {
		S2_Login_Page login = new S2_Login_Page(driver);
		login.clickOnMyAccountLink();
		login.clickOnLoginLink();
		login.enterUserName(TutorialsNinja_S2_Utilities.generateEmailWithTimeStamp());
		login.enterPassword(prop.getProperty("validPassword"));
		login.clickOnSignInButton();
		WebElement invalidUsernameMessage = login.invalidUsernameDisplayMessage(); 
		softassert.assertTrue(invalidUsernameMessage.isDisplayed(), "Invalid Credentials Message is not displayed");
		softassert.assertAll();
	}
	@Test(priority = 6)
	public void loginWithNoCredentials() {
		S2_Login_Page login = new S2_Login_Page(driver);
		login.clickOnMyAccountLink();
		login.clickOnLoginLink();
		login.enterUserName("");
		login.enterPassword("");
		login.clickOnSignInButton();
		WebElement noCredentialsMessage = login.noCredentialsDisplayMessage(); 
		softassert.assertTrue(noCredentialsMessage.isDisplayed(), "Invalid Credentials Message is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		
		
		
		
		
	
		
		
	}
	

}
