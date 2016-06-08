package upload;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.StaticBucketMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenImages 
{
	WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	
	uidriver.get("http://topbutton.com/Home/Default.aspx");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void findbrokenimages() throws Exception
	{
		
	
		
		List<WebElement> allImages =uidriver. findElements(By.tagName("img"));
			
int count= allImages.size();

boolean isvalid= false;

for (int i = 0; i < count; i++) 
{
	String url=allImages.get(i).getAttribute("href");
System.out.println(url);

if (url !=null)
{
	isvalid=checkBroken(url);
}
}
	}
	
	public static boolean checkBroken(String CheckUrl) throws Exception
	{
		boolean validresponse=false;
		try {
			
			HttpResponse hp= new DefaultHttpClient().execute(new HttpGet(CheckUrl));
			int resp_Code = hp.getStatusLine().getStatusCode();
			System.out.println("Response Code Is : "+resp_Code); 
			if ((resp_Code == 404) || (resp_Code == 505)) { validresponse = false; } else { validresponse = true; } } 
		catch (Exception e) { } return validresponse; } 
		
		
	
		
}

