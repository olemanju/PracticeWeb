package com.ole.work;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SenthilDraganDrop {
	
	WebDriver driver;
	 
	 @BeforeTest
	 public void setUp(){
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("http://jqueryui.com/draggable/");
	  
	 }
	 /**Drags and Drops an element to a location specified
	  * @author Senthil
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 
	 @Test
	 public void dragDrop() throws InterruptedException{
	
	  WebElement ifr = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	  driver.switchTo().frame(ifr);
	  
	  WebElement element=driver.findElement(By.xpath("//div[1]"));
	  int xCo = element.getLocation().getX();
	  int yCo = element.getLocation().getY();
	  System.out.println(+xCo+","+yCo);
	  xCo = xCo+100;
	  yCo = yCo+200;
	  
	    Actions actn=new Actions(driver);
	  actn.dragAndDropBy(element, xCo, yCo).build().perform();
	 }
	 
	 @AfterTest
	 public void tearDown(){
	  
	 // driver.quit();
	  
	 }
	 
}
