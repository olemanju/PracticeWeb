package upload;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch
{
	WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}

	@Test
public void searcme() throws Exception
{
		
//WebElement gg= uidriver.findElement(By.xpath("//input[@aria-autocomplete='both']"));
//gg.sendKeys("facebook",Keys.ENTER);
//Thread.sleep(6000);

WebElement email= uidriver.findElement(By.id("Email"));
email.sendKeys("manjuec.ole@gmail.com");

WebElement next= uidriver.findElement(By.id("next"));
next.click();

WebElement pass=uidriver.findElement(By.id("Passwd"));
pass.sendKeys("stupididiot");
WebElement signin= uidriver.findElement(By.id("signIn"));
signin.click();
Thread.sleep(4000);
}
}
