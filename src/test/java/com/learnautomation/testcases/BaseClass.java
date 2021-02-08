package com.learnautomation.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {

	public WebDriver driver ;
	public ExcelDataProvider excel ;
	public ConfigDataProvider config ;
	public ExtentReports reports ; 
	public ExtentTest logger ; 
	
	//create a method just to initalize all objects thats required in project and extend to this base class to access these
	@BeforeSuite
	public void setupSuite() throws Throwable {
		
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 
		 reports = new ExtentReports();
		 ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir"))+"/Reports/" + Helper.getCurrentTimeStamp() + ".html");
		 reports.attachReporter(extent);
		 
	}
	
	@BeforeClass
	public void setUp() {
		//driver = BrowserFactory.startApplication(driver, "Chrome", "http://demo.guru99.com/test/newtours/login.php");
		driver = BrowserFactory.startApplication(driver, config.getDataFromConfig("browser"), config.getDataFromConfig("url"));
		
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult Result) {
	
		if(Result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			logger.fail("test has failed");
		}
		else if (Result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("test has passed");
		}
		
		reports.flush();// this will keep on adding the tests in to a single report
	}
	
	
	
}
