package upload;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multipleactions 
{
	WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://only-testing-blog.blogspot.in/2013/09/test.html#sthash.7oZVtK8u.dpuf");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}

	@Test
	public void multipleselection() throws Exception
	{
		
		WebElement fname= uidriver.findElement(By.id("fname"));
		fname.sendKeys("Manjunath");
		
		WebElement lname= uidriver.findElement(By.name("lname"));
		boolean flag= lname.isEnabled();
		if (flag)
		{
			System.out.println("Text box is enabled");
		}
		else
		{
			System.out.println("Disabled");
		}
		//Multi select Check box
		
		List<WebElement> vechilecheckbox= uidriver.findElements(By.xpath("//input[@type='checkbox']"));
		int count=vechilecheckbox.size();
		
		for (int i = 0; i < count; i++) 
		{
			vechilecheckbox.get(i).click();
		}
		
		//Gender selection
		List<WebElement> gender= uidriver.findElements(By.xpath("//input[@name='gender']"));
		
		boolean gen_value=false;
	
		gen_value=gender.get(0).isSelected();
		
		if (gen_value=true)
		{
			gender.get(1).click();
			System.out.println(gender.get(1).getAttribute("value"));
		}
		else
		{
			gender.get(0).click();
			System.out.println(gender.get(0).getAttribute("value"));
		}
		
		WebElement browse=uidriver.findElement(By.name("img"));
		browse.sendKeys("C:\\Users\\manjunathr\\Desktop\\1.docx");
		
		
		Select drpselect= new Select(uidriver.findElement(By.xpath("//div/div/select[1]")));
		drpselect.selectByIndex(1);
		Thread.sleep(5000);
		
		WebElement getconfirm= uidriver.findElement(By.xpath("//button[contains(@onclick,'myFunction()')]"));
		getconfirm.click();
		
		Alert getalert= uidriver.switchTo().alert();
		String value=getalert.getText();
		System.out.println(value);
		getalert.accept();
		Thread.sleep(6000);
		
		
		WebElement showmealert= uidriver.findElement(By.xpath("//input[@value='Show Me Alert']"));
		showmealert.click();
				Alert showalert= uidriver.switchTo().alert();
				String textvalue= showalert.getText();
				System.out.println(textvalue);
				showalert.accept();
				Thread.sleep(5000);
	}
}
