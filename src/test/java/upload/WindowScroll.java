package upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowScroll 
{
WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://startingwithseleniumwebdriver.blogspot.in/2014/10/taking-screen-shot-of-particular.html");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
@Test
public void scrollMeUp() throws Exception
{
	/*JavascriptExecutor js= (JavascriptExecutor)uidriver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(6000);*/
	
	JavascriptExecutor jss= (JavascriptExecutor)uidriver;
	jss.executeScript("window.scroll(0,800)");
	Thread.sleep(6000);
	
	
	
	/*Actions actscroll= new Actions(uidriver);
	actscroll.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	Thread.sleep(10000);*/
	
	}
}
