package upload;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingFrames
{
	
	WebDriver uidriver;
	
	By firstname= By.name("firstname");
	By heading=By.xpath("//div[1]/h5");
	String actusl="Unique & Clean";
	By para= By.xpath("//div[@id='content']//h1");
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://toolsqa.com/iframe-practice-page/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}

	@Test
	public void HandleFrame() throws Exception
	{
		List<WebElement> numberofframe= uidriver.findElements(By.tagName("iframe"));
		System.out.println(numberofframe.size());
		
		JavascriptExecutor js=(JavascriptExecutor)uidriver;
		Integer count= Integer.parseInt(js.executeScript("return window.length").toString());
		System.out.println(count);
		
		uidriver.switchTo().frame(0);
		WebElement fnme= uidriver.findElement(firstname);
		fnme.sendKeys("Manjunath");
		Thread.sleep(5000);
		//uidriver.switchTo().frame(1);
		uidriver.switchTo().defaultContent();
		
		uidriver.switchTo().frame(uidriver.findElement(By.name("iframe2")));
		Thread.sleep(4000);
		WebElement head= uidriver.findElement(heading);
		String expect= head.getText().trim();
		Assert.assertEquals(actusl, expect, "bothe text are not Matching");
		
		Thread.sleep(5000);
		uidriver.switchTo().defaultContent();
		WebElement par= uidriver.findElement(para);
		System.out.println(par.getText());
	}

}
