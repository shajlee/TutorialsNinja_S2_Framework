package com.qa.tutorialsninjaS2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Landing_Page {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Desktops']")
	public WebElement desktopsButton;
	
	@FindBy(xpath = "//div[@id='logo']/child::h1/child::a")
	public WebElement qaFoxLink;
	
	public S2_Landing_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement desktopsLink() {
		return desktopsButton;
	}
	public boolean desktopsLinkIsDisplayed() {
		boolean displayStatus = desktopsButton.isDisplayed();
		return displayStatus;
	}
	public WebElement qaFoxLink() {
		return qaFoxLink;
	}
	public boolean qaFoxLinkIsDisplayed() {
		boolean displayStatus = qaFoxLink.isDisplayed();
		return displayStatus;
	}
	
	
	
	

}
