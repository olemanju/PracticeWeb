package com.ole.work;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks 
{
	WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://www.citibank.co.in/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	@Test
	public void checkBrokednLinks() throws Exception
	{
		List<WebElement> mylinks= uidriver.findElements(By.tagName("a"));
		int lnkcount= mylinks.size();
		System.out.println(lnkcount);
		
		for (WebElement linksname : mylinks) 
		{
			String lname=linksname.getAttribute("href");
			System.out.println(lname);
			
			boolean Isvalid=false;
			
		}
		
	}
}
