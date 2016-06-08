package com.in.ss;

import java.awt.RadialGradientPaint;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OnlyTestingWorkbook 
{
	WebDriver uidriver;
	

	@BeforeTest
	public void setup()
	{
		uidriver = new FirefoxDriver();
		uidriver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html#sthash.WB85jeQl.dpuf");
		uidriver.manage().window().maximize();
		uidriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown()
	{
		uidriver.quit();
	}
	
	@Test
	public void basicoperations() throws Exception
	{
		try 
		{
			
			WebElement firstname= uidriver.findElement(By.xpath("//input[@enabled='true']"));
			firstname.sendKeys("Manjunath");
			
			List<WebElement> multicheckbox= uidriver.findElements(By.xpath("//input[@name='vehicle']"));
			
			int count=multicheckbox.size();
			
			for (int i = 0; i < count; i++) 
			{
				String names= multicheckbox.get(i).getText();
				multicheckbox.get(i).click();
				System.out.println(names);
			}
			
			Thread.sleep(4000);
		} 
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
		
	}
	
	@Test
	public void fileUploadDropdown() throws Exception
	{
		try 
		{
			List<WebElement> radbuttonselect= uidriver.findElements(By.xpath("//input[@name='gender']"));
			boolean isSelected= false;
			radbuttonselect.get(0).isSelected();
			if(isSelected==true)
			{
				radbuttonselect.get(1).click();
			}
			else
			{
				radbuttonselect.get(0).click();
			}
		
			WebElement upload= uidriver.findElement(By.name("img"));
			upload.sendKeys("C:\\Users\\manjunathr\\Desktop\\1.docx");
			String gettext= upload.getText();
			System.out.println(gettext);
			Thread.sleep(3000);
			
			Select drpselect= new Select(uidriver.findElement(By.xpath("//div/div/select[1]")));
			drpselect.selectByIndex(1);
			Thread.sleep(4000);
			
			
		} 
		
	
		catch (Exception e) 
		{
			// TODO: handle exception
		throw new Exception(e.getMessage());
		}
	}
	
	@Test
	public void ListboxSelection() throws Exception
	{
		
		Select ltselect= new Select(uidriver.findElement(By.xpath("//select[@name='FromLB']")));
		ltselect.selectByIndex(1);
		ltselect.selectByIndex(3);
		
		WebElement forward= uidriver.findElement(By.xpath("//input[@value='->']"));
		forward.click();
		
		WebDriverWait wait= new WebDriverWait(uidriver, 15);
		//wait.until(Expected.Conditions.elementTobeClickable(By.id("text2")));
	}
	
	@Test
	public void handlealerts() throws Exception
	{
		try
		{
			WebElement showmebutton= uidriver.findElement(By.xpath("//button[text()='Show Me Confirmation']"));
			showmebutton.click();
			
			Alert at= uidriver.switchTo().alert();
			String text= at.getText();
			System.out.println("I am " + text);
			at.dismiss();
			Thread.sleep(3000);
			
			WebElement val_message= uidriver.findElement(By.id("demo"));
			String axc=val_message.getText();
			System.out.println(axc);
			
			WebElement showmealert= uidriver.findElement(By.xpath("//input[@value='Show Me Alert']"));
			showmealert.click();
			
			Alert atl= uidriver.switchTo().alert();
			String actual_message=atl.getText();
			System.out.println(actual_message);
			String expected="Hi.. This is alert message!";
			//Assert.assertEquals(expected, actual_message,"Both are not Matching");
		atl.accept();
		
		WebElement lastalert= uidriver.findElement(By.xpath("//button[contains(@onclick,'myFunctionf()')]"));
		lastalert.click();
		
		Alert all= uidriver.switchTo().alert();
		all.sendKeys("manjunath");
		all.accept();
		Thread.sleep(5000);
			
			
		}
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@Test
	public void handlingwebtable() throws Exception
	{
		try {
			WebElement complTable= uidriver.findElement(By.xpath("//table[@cellpadding='10']"));
			
			List<WebElement>trows= uidriver.findElements(By.xpath("//table[@cellpadding='10']/tbody/tr"));
			int rowcount=trows.size();
			
		
			
					for (int i = 0; i < rowcount; i++) 
					{
						List<WebElement> tcolumns= uidriver.findElements(By.xpath("//table[@cellpadding='10']/tbody/tr/td"));
						int colcount=tcolumns.size();
						
						for (WebElement cellname : tcolumns) 
						{
							cellname.getText();
							System.out.println(cellname.getText());
						}
					}
			
					
			
		} catch (Exception e) 
		{
		throw new Exception(e.getMessage());
		}
	}
	
	@Test
	public void Navigationexample() throws Exception
	{
		
		String urlname=uidriver.getCurrentUrl();
		uidriver.navigate().back();
		Thread.sleep(3000);
		uidriver.navigate().forward();
		
	}
}
