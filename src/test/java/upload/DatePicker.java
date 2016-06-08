package upload;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePicker 
{
	WebDriver uidriver;
	
	By datetextbox= By.id("datepicker");
	
	By NextBtn= By.xpath("//a[@title='Next']/span");
	
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://jqueryui.com/datepicker/");
	uidriver.switchTo().frame(0);
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test
public void DatePick() throws Exception
{
		WebElement datepicktext= uidriver.findElement(datetextbox);
		datepicktext.click();
		Thread.sleep(4000);
		
		WebElement Nextbt= uidriver.findElement(NextBtn);
		Nextbt.click();
		
		WebElement datewidget=uidriver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> rows= uidriver.findElements(By.tagName("tr"));
		List<WebElement> columns =uidriver.findElements(By.tagName("td"));
		
		for (WebElement cell : columns) 
		{
			if (cell.getText().equals("10"));
			{
				cell.findElement(By.linkText("10")).click();
				Thread.sleep(6000);
				break;
			}
			
		}
		
		
}
	
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
}
