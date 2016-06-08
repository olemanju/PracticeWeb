package com.ole.work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDropEx 
{

	WebDriver uidriver;
	
	By dragele=By.xpath("//div[@id='dragdiv']/p");
	By bropme=By.xpath("//div[@id='dropdiv']/p");
	
	
	@BeforeTest
	public void setup()
	{
		uidriver= new FirefoxDriver();
		//uidriver.get("http://only-testing-blog.blogspot.in/");
		uidriver.get("http://html5demos.com/drag");
		uidriver.manage().window().maximize();
		uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void  TestDragandDrop() throws Exception
	{
		try 
		{
			WebElement drag= uidriver.findElement(By.xpath("//article/ul/li[1]/a"));
			WebElement dropab=uidriver.findElement(By.xpath("//article/div[@id='bin']"));
			
			Actions actdr= new Actions(uidriver);
			actdr.clickAndHold(drag).moveToElement(dropab).release(dropab).build();
			actdr.perform();
			
			Thread.sleep(6000);
		}
		catch (Exception e) 
		{
			throw new Exception(e.getLocalizedMessage());
		}
		
	}
}
