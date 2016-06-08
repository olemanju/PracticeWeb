package com.ole.work;

import java.util.concurrent.TimeUnit;

import  org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkClickwindowHandle 
{
	WebDriver uidriver;

	/***********************************uielements*****************************************/

	
	By EmployerZonelink=By.partialLinkText("Employer Zone");
	By forgetPasswordlink=By.partialLinkText("Forgot Password?");

	/*************************************Variables****************************************/

	String expected_result= null;
	String actual_result=null;
	boolean flag=false;
	String parent_window=null;
	String child_window=null;



	@BeforeTest
	public void setup()
	{
		uidriver= new FirefoxDriver();
		uidriver.get("http://www.naukri.com/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
@Test

public void clickonEmplyerZone() throws Exception
{
try 
{
	
	WebElement empzone= uidriver.findElement(EmployerZonelink);
	flag=empzone.isDisplayed();
	
Assert.assertTrue( flag,"Empzone Elelement is Missing");

parent_window=uidriver.getWindowHandle();
empzone.click();


for (String childwindow : uidriver.getWindowHandles())
{
	uidriver.switchTo().window(childwindow);
}
Thread.sleep(5000);
	WebElement forgetpwd= uidriver.findElement(forgetPasswordlink);
	flag=forgetpwd.isDisplayed();
	
	Assert.assertTrue(flag,"Forget Password link is Missing");
	
	expected_result=forgetpwd.getText();
	actual_result="Forgot Password?";
	Assert.assertTrue(flag, "Forget Password Strings are not matching");
	
	WebElement frud= uidriver.findElement(By.linkText("Fraud Alert!"));
	frud.click();

for (String SecChild : uidriver.getWindowHandles()) 
{
	uidriver.switchTo().window(SecChild);
}
	WebElement head= uidriver.findElement(By.xpath("//div/strong"));
	String act= head.getText();
	System.out.println(act);
	Thread.sleep(4000);
	uidriver.close();
	
	uidriver.switchTo().window(child_window);
	Thread.sleep(4000);
	uidriver.close();
	
	uidriver.switchTo().window(parent_window);

	Thread.sleep(6000);
	
	
} catch (Exception e) 
{
throw new Exception(e.getMessage());
}	
}
}
