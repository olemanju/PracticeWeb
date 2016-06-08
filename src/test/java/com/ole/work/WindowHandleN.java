package com.ole.work;

import java.awt.Menu;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Submit;

public class WindowHandleN 
{
WebDriver uidriver;

/***********************************uielements*****************************************/

By SuperBuyOnline=By.xpath("//ul/li[2]/a[@title='Buy Online- RESDEX and Vacancy Listings']");
By childBuyonline=By.xpath("//li[1]/a[@title='Buy Online- RESDEX and Vacancy Listings']");
By PostinstaJob=By.partialLinkText("Post an Insta Job");
By CartEmpty=By.xpath("//div[@id='cartCont']");
By postinstaheading=By.xpath("//h1");
/*************************************Variables****************************************/

String expected_result= null;
String actual_result=null;
boolean flag=false;
String parent_window=null;
String child_window=null;



@BeforeTest
public void setup()
{
	uidriver= new FirefoxDriver();
	uidriver.get("http://www.naukri.com/");
uidriver.manage().window().maximize();
uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@AfterTest
public void teardown()
{
	uidriver.quit();
}

@Test
public void windowHandleTest() throws Exception
{
	try 
	{
		WebElement mainbuyonline= uidriver.findElement(SuperBuyOnline);
		flag=mainbuyonline.isDisplayed();
		Assert.assertTrue(flag,"Main Buy online Element is Missing on th Page");
		
	
	Actions menuAct= new Actions(uidriver);
	menuAct.moveToElement(mainbuyonline).build().perform();
		
		WebElement subbuyonline= uidriver.findElement(childBuyonline);
		flag=subbuyonline.isDisplayed();
		Assert.assertTrue(flag,"Sub Buy online Element is Missing");
		
		parent_window=uidriver.getWindowHandle();
		subbuyonline.click();
		
	for (String ChildBuyonlinewindow : uidriver.getWindowHandles()) 
	{
		uidriver.switchTo().window(ChildBuyonlinewindow);
		
	}
	
	WebElement cart= uidriver.findElement(CartEmpty);
	expected_result="Your cart is empty";
	actual_result=cart.getText().trim();
		Assert.assertEquals(actual_result, expected_result, "Both the Text are Not matching");
		
		uidriver.close();
		
		uidriver.switchTo().window(parent_window);
		
Actions menuact= new Actions(uidriver);
menuAct.moveToElement(mainbuyonline).build().perform();

WebElement postinsta= uidriver.findElement(PostinstaJob);
flag=postinsta.isDisplayed();
Assert.assertTrue(flag, "Post insta Link is Missing");


parent_window=uidriver.getWindowHandle();
postinsta.click();

for (String Childpost : uidriver.getWindowHandles())
{
	uidriver.switchTo().window(Childpost);
}

WebElement postheading= uidriver.findElement(postinstaheading);
actual_result=postheading.getText();
expected_result="Insta Job Posting";

Assert.assertEquals(actual_result, expected_result,"Heading is Not Matching");

uidriver.close();

uidriver.switchTo().window(parent_window);

System.out.println("Manjunath");
		
	} 
	catch (Exception e) 
	{
		
	}
	
	
	
}
}
