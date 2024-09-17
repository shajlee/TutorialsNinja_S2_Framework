package com.qa.tutorialsninjaS2.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.tutorialsninjaS2.pages.S2_Search_Page;
import com.qa.tutorialsninjaS2.testbase.Tutorials_Ninja_S2_TestBase;

public class S2_Search extends Tutorials_Ninja_S2_TestBase {
	public S2_Search() throws Exception {
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
	public void searchValidProduct() {
		S2_Search_Page search = new S2_Search_Page(driver);
		search.enterProduct(prop.getProperty("validProduct"));
		search.clickOnSearchButton();
		WebElement validProduct = search.validProductIsDisplayed(); 
		softassert.assertTrue(validProduct.isDisplayed(), "Valid Product is not displayed");
		softassert.assertAll();
	}
	@Test(priority=2)
	public void searchInvalidProduct() {
		S2_Search_Page search = new S2_Search_Page(driver);
		search.enterProduct(prop.getProperty("invalidProduct"));
		search.clickOnSearchButton();
		WebElement invalidProduct = search.invalidProductIsDisplayMessage(); 
		softassert.assertTrue(invalidProduct.isDisplayed(), "invalid product is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
	}
	

}
