package upload;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest 
{
	
WebDriver uidriver;

String filePath="D:\\Personal\\Testlead.docx";
By inputfilebutton= By.id("inpFile");
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://my.naukri.com/manager/createacc2.php?othersrcp=16201&err=1");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
	
	@Test
	public void Uploadmefile() throws Exception
	{
		WebElement txt= uidriver.findElement(By.id("txt2"));
		WebDriverWait wait= new WebDriverWait(uidriver, 15);
		wait.until(ExpectedConditions.visibilityOf(txt));
		
		WebElement sub= uidriver.findElement(By.xpath("//input[@id='submitbtn']"));
		System.out.println(sub.getCssValue("font-size"));
		System.out.println(sub.getCssValue("font-color"));
		System.out.println(sub.getCssValue("background-color"));
		
		String a= (String)((JavascriptExecutor)uidriver).executeScript("return navigator.userAgent");
		System.out.println(a);
		
		((JavascriptExecutor)uidriver).executeScript("window.scrollBy(0, 800)");
		WebElement filep= uidriver.findElement(inputfilebutton);
		filep.sendKeys(filePath);
		
		String pa= filep.getAttribute("value");
		System.out.println(pa);
		Thread.sleep(8000);
		
		File takemsnap= ((TakesScreenshot)uidriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(takemsnap, new File("C:\\Users\\manjunathr\\Desktop\\Manjunath.jpeg"));
	}

}
