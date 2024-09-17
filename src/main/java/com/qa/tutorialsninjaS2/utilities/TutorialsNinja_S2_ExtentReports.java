package com.qa.tutorialsninjaS2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TutorialsNinja_S2_ExtentReports {
	
	public static ExtentReports generateNinjaS1EntentReport() throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Tutorials Ninja S1 Automation Tests Results");
		sparkReporter.config().setDocumentTitle("Tutorials Ninja S1 Tests");
		sparkReporter.config().setReportName("Golam Shajlee Adeeb Chowdhury");
		sparkReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties reportProp = new Properties();
		FileInputStream reportIp = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\tutorialsninjaS2\\Configurations\\config.properties");
		reportProp.load(reportIp);
		
		extentReport.setSystemInfo("Application URL", reportProp.getProperty("url"));
		extentReport.setSystemInfo("Project Browser", reportProp.getProperty("browserName1"));
		extentReport.setSystemInfo("Valid Email", reportProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Valid Password", reportProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extentReport.setSystemInfo("Java Runtime Version", System.getProperty("java.runtime.version"));
		extentReport.setSystemInfo("Java Vendor", System.getProperty("java.vm.specification.vendor"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("User Country", System.getProperty("user.country"));
		extentReport.setSystemInfo("User Language", System.getProperty("user.language"));
		
		return extentReport;
		
		

}
}
