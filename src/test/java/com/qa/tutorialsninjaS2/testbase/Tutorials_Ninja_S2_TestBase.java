package com.qa.tutorialsninjaS2.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.tutorialsninjaS2.utilities.TutorialsNinja_S2_Utilities;

public class Tutorials_Ninja_S2_TestBase {
	
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static Properties prop;
	public static FileInputStream ip;
	
	public Tutorials_Ninja_S2_TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\qa\\tutorialsninjaS2\\Configurations\\config.properties");
		prop.load(ip);
		
	}
	
	public WebDriver initializeAndOpenBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			optionsC.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new EdgeDriver();
		}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TutorialsNinja_S2_Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TutorialsNinja_S2_Utilities.PAGELOAD_WAIT_TIME));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TutorialsNinja_S2_Utilities.SCRIPTLOAD_WAIT_TIME));
			driver.manage().deleteAllCookies();
			return driver;
			
			
			
			
		
			
		}
		
	}


