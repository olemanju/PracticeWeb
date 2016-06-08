package upload;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RediffWebtable
{
WebDriver uidriver;
	
	@BeforeTest
	public void setup()
	{
	uidriver= new FirefoxDriver();
	uidriver.get("http://money.rediff.com/index.html");
	uidriver.manage().window().maximize();
	uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest
	public void teardown()
	{
		uidriver.quit();
	}
@Test
public void rediftableread() throws Exception
{
	WebElement red_table=uidriver.findElement(By.id("allpage_links"));
	
	List<WebElement> rows_table= uidriver.findElements(By.xpath("//table[@id='allpage_links']/tbody/tr"));
	int rowcount=rows_table.size();
	System.out.println("Number of rows  " + rowcount);
	
	for (int row = 0; row < rowcount; row++) 
	{
		List<WebElement> column_table=uidriver.findElements(By.xpath("//table[@id='allpage_links']/tbody/tr/td"));
		int column_count=column_table.size();
		System.out.println("Number of columns  " + column_count);
		
		
		for (WebElement names : column_table) 
		{
			System.out.println("column Text is  " + names.getText());
		}
	}


}
}
