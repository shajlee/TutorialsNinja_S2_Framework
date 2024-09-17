package com.qa.tutorialsninjaS2.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.tutorialsninjaS2.pages.S2_Logout_Page;
import com.qa.tutorialsninjaS2.testbase.Tutorials_Ninja_S2_TestBase;

public class S2_Logout extends Tutorials_Ninja_S2_TestBase  {
	public S2_Logout() throws Exception {
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
	public void logOutTest() {
		S2_Logout_Page logout = new S2_Logout_Page(driver);
		logout.clickOnMyAccountLink();
		logout.clickOnLoginLink();
		logout.enterUsername(prop.getProperty("validEmail"));
		logout.enterPassword(prop.getProperty("validPassword"));
		logout.clickOnSigninButton();
		logout.clickOnMyAccountLink();
		logout.clickOnLogoutButton();
		WebElement accountLogoutMessage = logout.logoutDisplayMessage(); //driver.findElement(By.cssSelector("div#content h1+p"));
		softassert.assertTrue(accountLogoutMessage.isDisplayed(), "Account logout is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
