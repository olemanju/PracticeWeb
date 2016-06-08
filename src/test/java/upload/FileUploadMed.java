package upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadMed 
{
	
	WebDriver uidriver;
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://www.megafileupload.com/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
public void uploadme() throws Exception
{
		WebElement upld= uidriver.findElement(By.xpath("//div[@id='initialUploadSection']/div[1]"));
		upld.click();
		Thread.sleep(6000);
		Runtime.getRuntime().exec("D:/Software/autoit/uoload.exe");
		
}
	
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
}
