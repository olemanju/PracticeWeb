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

public class WebtableData 
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
	public void handlewebtable() throws Exception
	{
		//To Locate Table
		//WebElement webtable= uidriver.findElement(By.xpath("//table[@cellpadding='10']/tbody"));
		WebElement webtable=uidriver.findElement(By.xpath("//div[@id='post-body-6522850981930750493']/div//table[@cellpadding='10']/tbody"));
		
		//To Locate Rows of the table 
		List<WebElement> rows_table= uidriver.findElements(By.xpath("//table[@cellpadding='10']/tbody/tr"));
		int totalRowscount=rows_table.size();
		System.out.println("Number of Rows  " + totalRowscount);
		

for (int row = 0; row< totalRowscount; row++) 
{
	List<WebElement> column_table= uidriver.findElements(By.xpath("//table[@cellpadding='10']/tbody/tr/td"));
	int column_count= column_table.size();
	System.out.println("Number of columns  " +column_count); 

	for (WebElement celltext : column_table)
	{
		
		System.out.println(" column Text value  " + celltext.getText());
	}
/*for (int column = 0; column < column_count; column++)
{
	String cell_text= column_table.get(column).getText();
	System.out.println("column Text value  " + cell_text);
}*/

	}
}
}
