package upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RefreshMe 
{
WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://www.flipkart.com/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void refrehMeBuddy() throws Exception
	{
		
		try {
			
			uidriver.navigate().refresh();
			Thread.sleep(3000);
			uidriver.get(uidriver.getCurrentUrl());
			Thread.sleep(3000);
			uidriver.navigate().to(uidriver.getCurrentUrl());
			Thread.sleep(3000);
			uidriver.findElement(By.partialLinkText("Login")).sendKeys(Keys.F5);
			Thread.sleep(3000);
			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
