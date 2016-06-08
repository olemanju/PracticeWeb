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

public class RightClickFacebook {

	WebDriver uidriver;
	
	By Passlink=By.partialLinkText("Forgotten your password?");
	
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
	public void RightclcikPasswordlink() throws Exception
	{
		try 
		{
			String Parent_window= uidriver.getWindowHandle();
			
			WebElement passlnk= uidriver.findElement(Passlink);
			
			Actions actlinks= new Actions(uidriver);
			actlinks.moveToElement(passlnk).contextClick(passlnk).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
			Thread.sleep(6000);
			actlinks.build().perform();
			
			for (String childwindow : uidriver.getWindowHandles()) 
			{
				uidriver.switchTo().window(childwindow);
			}
			Thread.sleep(6000);
			uidriver.close();
			
			
			uidriver.switchTo().parentFrame();
		
			
		} 
		catch (Exception e) 
		{
			throw new Exception(e.getLocalizedMessage());
		}
	}
}
