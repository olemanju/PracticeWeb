package upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Testdownloadfile
{
	WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
		uidriver= new FirefoxDriver();
		uidriver.get("http://www.bcsrecruit.com/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}

	
}
