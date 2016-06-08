package com.ole.work;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickAndHold
{
	
	WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
		uidriver= new FirefoxDriver();
		uidriver.get("http://startingwithseleniumwebdriver.blogspot.in/2013/12/frmset1.html");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void clickAndHoldWork() throws Exception
	{
		try 
		{
			WebElement multi= uidriver.findElement(By.name("multiselectdropdown"));
			List<WebElement>multidrop= multi.findElements(By.tagName("option"));
			
			Actions actmul= new Actions(uidriver);
			actmul.clickAndHold(multidrop.get(0)).moveToElement(multidrop.get(5)).release().build().perform();
			Thread.sleep(6000);
			
			
		} 
		catch (Exception e) 
		{
			
		}
		
	}
}
