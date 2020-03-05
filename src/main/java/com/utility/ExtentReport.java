package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {
WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest tests;
	
	@BeforeTest
	public void createReport() {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String filePath=System.getProperty("user.dir")+"reports/extent-reports"+format.format(new Date())+".html";
		
		reporter=new ExtentHtmlReporter(filePath);
		ExtentReports report=new ExtentReports();
		report.attachReporter(reporter);
		
	}
	@BeforeMethod
	public void createTest(ITestResult result) {
		tests=report.createTest(result.getMethod().getMethodName());
	}
	@AfterTest
	public void copyReport() {
		report.flush();
	}
	@AfterMethod
	public void takeScreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			String descFile="./reports/Screenshots"+result.getMethod().getMethodName()+".png";
			try {
				FileUtils.copyFile(srcFile, new File(descFile));
				tests.log(Status.PASS, result.getMethod().getMethodName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			String descFile="./reports/Screenshots"+result.getMethod().getMethodName()+".png";
			try {
				FileUtils.copyFile(srcFile, new File(descFile));
				tests.log(Status.FAIL, result.getThrowable().getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
