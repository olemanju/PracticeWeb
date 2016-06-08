package upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownLoad 
{
WebDriver uidriver;


public static String  DownloadPath="D:\\files";

@BeforeTest
	public void setup() throws Exception
	{
	uidriver= new FirefoxDriver(FirefoxDriverProfile());
	uidriver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  uidriver.findElement(By.linkText("smilechart.xls")).click();

	}

	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public   FirefoxProfile FirefoxDriverProfile() throws Exception
	{
		try
		{
			FirefoxProfile profile = new FirefoxProfile();
			
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.dir", DownloadPath);
			profile.setPreference("browser.helperApps.neverAsk.openFile",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
	"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.closeWhenDone", false);
			
		return profile;
			
		} catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}	
		
	}
}
