package com.in.ss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Naukri 
{
WebDriver uidriver;
	

	@BeforeTest
	public void setup()
	{
		uidriver = new FirefoxDriver();
		uidriver.get("http://www.naukri.com/");
		uidriver.manage().window().maximize();
		uidriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		Thread.sleep(5000);
		uidriver.quit();
	}
	
	@Test
	
	public void clickonMenulinks() throws Exception
	{
		
		WebElement buyon1= uidriver.findElement(By.xpath("//ul/li[2]/a[@title='Buy Online- RESDEX and Vacancy Listings']"));
		
		String Parentwindow= uidriver.getWindowHandle();
		
		 WebElement emp= uidriver.findElement(By.partialLinkText("Employer Zone"));
		 emp.click();
		 
		 for (String childlinks : uidriver.getWindowHandles()) 
		 {
			 uidriver.switchTo().window(childlinks);
		}
		 WebElement head= uidriver.findElement(By.xpath("//div/div/span/a[2]/strong"));
		 String res=head.getText();
		 System.out.println(res);
		 
		 WebElement reportaproblem= uidriver.findElement(By.partialLinkText("Report a Problem"));
		 reportaproblem.click();
		 
		 Thread.sleep(4000);
		 for (String childlinks : uidriver.getWindowHandles()) 
		 {
			 uidriver.switchTo().window(childlinks);
		}
		 
		 uidriver.findElement(By.name("strName")).sendKeys("Sample");
		 uidriver.findElement(By.name("strEmail")).sendKeys("manju@gmail.com");
		 uidriver.findElement(By.name("Submit"));
		 Thread.sleep(5000);
		 uidriver.close();
		 uidriver.switchTo().window(Parentwindow);
		
	}
}
