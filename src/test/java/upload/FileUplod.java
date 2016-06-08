package upload;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUplod

{
	
	WebDriver uidriver;
By browsebutton= By.id("file-upload");
By file_submit= By.id("file-submit");


String FilePath="C:\\Users\\manjunathr\\Desktop\\1.docx";

@BeforeTest
public void setup()
{
uidriver= new FirefoxDriver();
uidriver.get("http://the-internet.herokuapp.com/upload");
uidriver.manage().window().maximize();
uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@AfterTest
public void teardown()
{
	uidriver.quit();
}

@Test
public void uploadme() throws Exception
{
try {
	WebElement brs= uidriver.findElement(browsebutton);
	brs.sendKeys(FilePath);
	
	String savedpath= brs.getAttribute("value");
	System.out.println(savedpath);
	Thread.sleep(6000);
	WebElement submitme= uidriver.findElement(file_submit);
	submitme.click();
	Thread.sleep(6000);
	
	File mysnap=((TakesScreenshot)uidriver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(mysnap, new File("C:\\Users\\manjunathr\\Desktop\\Manjunath.jpeg"));
	
} catch (Exception e) {
	// TODO: handle exception
}	
}
}
