package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	//initializing construtor
	public LoginPage(WebDriver driver) 
	{	
		this.driver = driver;
	}
	
	//implementation of pagefatory
	@FindBy(name="userName") WebElement username ;
	@FindBy(name="password") WebElement password ;
	@FindBy(name="submit") WebElement submit ;
	
	
	public void logintoCRM(String uname, String pswrd) throws InterruptedException {
		username.sendKeys(uname);
		password.sendKeys(pswrd);
		submit.click();
		Thread.sleep(5000);
	}
	
	
}
