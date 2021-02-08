package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	//helper methods for screenshot	, alerts , frames , windows , sync issue , javascript executor
	
	public static String captureScreenshot(WebDriver driver) 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots" + Helper.getCurrentTimeStamp() + ".png";
		
		
		
		try {
			//FileHandler.copy(src, new File("./Screenshots/Login.png"));
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot is captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot : " + e.getMessage());
			
			
		}
		return screenshotPath;
		
	}
	

	
	public static String getCurrentTimeStamp() {
		
		SimpleDateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
		
		
	}
	
	public static void handleAlert() {
		
	}
	
	public void handleFrame() {
		
	}
	
	
	
	
}
