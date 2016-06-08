package com.ole.work;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkwithSSL
{
WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
		//SSL Error Handle
	DesiredCapabilities capabalities= new DesiredCapabilities().chrome();
	capabalities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	
	System.setProperty("webdriver.chrome.driver", "D://Automation//Practiceweb//Drivers//chromedriver.exe");
	//System.setProperty("webdriver.ie.driver", "D://Automation//Practiceweb//Drivers//IEDriverServer.exe");
	uidriver=new ChromeDriver();
	//uidriver= new InternetExplorerDriver();
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
