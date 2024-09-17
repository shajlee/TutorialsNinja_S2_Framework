package com.qa.tutorialsninjaS2.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.tutorialsninjaS2.pages.S2_Inbox_Page;
import com.qa.tutorialsninjaS2.testbase.Tutorials_Ninja_S2_TestBase;

public class S2_Inbox extends Tutorials_Ninja_S2_TestBase {
	public S2_Inbox() throws Exception {
		super();
		
	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeAndOpenBrowser("chrome");		
	}
	@Test(priority =1)
	public void validLogin() {
		S2_Inbox_Page inbox = new S2_Inbox_Page(driver);
		inbox.clickOnMyAccountLink();
		inbox.clickOnLoginLink();
		inbox.enterUserName(prop.getProperty("validEmail"));
		inbox.enterPassWord(prop.getProperty("validPassword"));
		inbox.clickOnSignInButton();
		
		WebElement myAccoutnDisplay = inbox.myAccountDisplay(); 
		softassert.assertTrue(myAccoutnDisplay.isDisplayed(), "My Account Button is not displayed");
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
	}

}
