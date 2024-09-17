package com.qa.tutorialsninjaS2.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.tutorialsninjaS2.utilities.TutorialsNinja_S2_ExtentReports;

public class TutorialsNinja_S2_Listeners implements ITestListener {
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = TutorialsNinja_S2_ExtentReports.generateNinjaS1EntentReport();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//ITestListener.super.onStart(context);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReport.createTest(TestName);
		extentTest.log(Status.INFO, TestName + "Scripted, Initialized & Started Executing");
		
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReport.createTest(TestName);
		extentTest.log(Status.PASS, TestName + "Tested & Successfully Executed");
		
		
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + TestName + ".png";
		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(destination);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, TestName + "failed");
		
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReport.createTest(TestName);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, TestName + "Got Skipped");
		
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String TestName = result.getName();
		System.out.println(TestName + "With This Much Percentage");
		System.out.println(result.getThrowable());
		
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Tutorials Ninja S1 Project Initialized, Executed and Successfully Concluded");
		extentReport.flush();
		
		//ITestListener.super.onFinish(context);
	}

	
	}
	


