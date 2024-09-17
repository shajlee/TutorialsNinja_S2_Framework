package com.qa.tutorialsninjaS2.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.tutorialsninjaS2.pages.S2_Landing_Page;
import com.qa.tutorialsninjaS2.testbase.Tutorials_Ninja_S2_TestBase;

public class S2_Landing extends Tutorials_Ninja_S2_TestBase	 {
	public S2_Landing() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeAndOpenBrowser("chrome");
	}
	@Test(priority=1)
	public void validateTitleAndCurrentUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		String actualTitle = prop.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();
		
		String actualUrl = prop.getProperty("actualUrl");
		String expectedUrl = driver.getCurrentUrl();
		
		if(actualTitle.equals(expectedTitle) && actualUrl.equals(expectedUrl)){
			System.out.println("The Page is valid and functional");
		}else {
			System.out.println("The page is invalid and not functional");
		}
	}
	
	@Test(priority=2)
	public void desktopsButtonIsDisplayedAndEnabled() {
		S2_Landing_Page landingPage = new S2_Landing_Page(driver);
		WebElement desktopsButton = landingPage.desktopsButton; 
		softassert.assertTrue(desktopsButton.isDisplayed(), "sign in button is not displayed");
		softassert.assertAll();
	}
	@Test(priority=2)
	public void qaFoxLogoIsDisplayed() {
		S2_Landing_Page landingPage = new S2_Landing_Page(driver);
		WebElement qaFoxLogo = landingPage.qaFoxLink; 
		softassert.assertTrue(qaFoxLogo.isDisplayed(), "QA Fox Logo is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	
	
		
		
	}
	

}
