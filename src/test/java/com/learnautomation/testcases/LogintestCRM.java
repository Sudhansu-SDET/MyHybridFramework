package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class LogintestCRM extends BaseClass{

	
	@Test
	public void loginApp() throws InterruptedException {
		
		logger  = reports.createTest("Login to application");
		
		LoginPage myLoginPage = PageFactory.initElements(driver, LoginPage.class);
		//myLoginPage.logintoCRM("Admin", "admin123");
		
		logger.info("Starting the application");
		
		
		myLoginPage.logintoCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("hello123"));
	
		logger.pass("Logged in successfully");
		
		
	}
	


}
