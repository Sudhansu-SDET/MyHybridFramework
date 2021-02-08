package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL) {
		
		if(browserName.equalsIgnoreCase("Chrome")) 
		{
			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudpatro\\Desktop\\MYDOCS\\SeleniumLearning\\chromedriver88\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.out.println("This driver is yet to be setup " + browserName);
		}
		else if(browserName.equalsIgnoreCase("IE")) 
		{
			System.out.println("This driver is yet to be setup " + browserName);
		}
		else {
		
			System.out.println("This browser is not supported " + browserName);
		}
			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appURL);
		
		return driver;
		
	}
	
	
	//teardown method
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	
	}
}
