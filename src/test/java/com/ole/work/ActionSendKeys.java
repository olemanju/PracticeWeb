package com.ole.work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionSendKeys {
	
WebDriver uidriver;

By emailid= By.id("email");

	String expected_result= null;
	String actual_result=null;
	boolean flag=false;
	String parent_window=null;
	String child_window=null;



	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("https://www.facebook.com/?_rdr=p");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void ActionSendkeysTest() throws Exception
	{
		try
		{
			WebElement emailtxt= uidriver.findElement(emailid);
			
			
			Actions act= new Actions(uidriver);
			act.moveToElement(emailtxt).keyDown(emailtxt, Keys.SHIFT).sendKeys(emailtxt,"manju");
			act.build().perform();
			Thread.sleep(6000);
		} 
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
}
