package com.ole.work;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.ini4j.Reg;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts 
{

	WebDriver uidriver;
	
	/*************Elelments ************************************************************/
	
	By RegisterButton= By.xpath("//input[@value='Register']");
	By EmailTextbox= By.id("email");
	
	/****************************************Variables**********************************/
	
	String expected_result=null;
	String actual_resul=null;
	String Message=null;
	boolean flag=false;
	
	@BeforeTest
	public void setup()
	{
		uidriver= new FirefoxDriver();
		//D:\Automation\Practiceweb\Drivers
		//System.setProperty("webdriver.ie.driver","D://Automation//Practiceweb//Drivers//IEDriverServer.exe");
		//System.setProperty("webdriver.chrome.driver","D://Automation//Practiceweb//Drivers//chromedriver.exe");
		//uidriver= new ChromeDriver();
	//uidriver= new InternetExplorerDriver();
	uidriver.get("http://www.bcsrecruit.com/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void handlealerts() throws Exception
	{
		try 
		{
			WebElement regbut= uidriver.findElement(RegisterButton);
			Thread.sleep(6000);
			regbut.click();
			
			Alert regalert= uidriver.switchTo().alert();
			actual_resul=regalert.getText();
			
			expected_result="Please enter a value for the Email Address field.";
			Assert.assertEquals(actual_resul, expected_result,"Both the Strings are not matching");
			regalert.accept();
			Thread.sleep(6000);
		} 
		catch (Exception e) 
		{
			throw new Exception(e.getLocalizedMessage());
		}
	}
	@Test
	public void emailValidation() throws Exception
	{
		WebElement emailtxt= uidriver.findElement(EmailTextbox);
		emailtxt.sendKeys("qwqwqw");
		
		
		Message=emailtxt.getText();
		uidriver.findElement(RegisterButton).click();
		
	Alert emailalert= uidriver.switchTo().alert();
	actual_resul=emailalert.getText();
	expected_result="Email addresses must contain one @ symbol and at least one dot";
	Assert.assertEquals(actual_resul, expected_result, "Alert pop Message Text is not Matching");
	emailalert.accept();
	
	emailtxt.clear();
	emailtxt.sendKeys("manju@gmail.com");
	Thread.sleep(6000);
	uidriver.findElement(RegisterButton).click();
		
	
	}
}
