package com.ole.work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick {
	
	WebDriver uidriver;
	
	By doubleButton= By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]");
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
@Test
public void TestDoubleClick() throws Exception
{
	WebElement doublebtn= uidriver.findElement(doubleButton);
	
	Actions actdb= new Actions(uidriver);
	actdb.doubleClick(doublebtn).build().perform();
	
	Thread.sleep(5000);
	Alert atl= uidriver.switchTo().alert();
	String message= atl.getText();
	System.out.println(message);
	
	atl.accept();
}
}
