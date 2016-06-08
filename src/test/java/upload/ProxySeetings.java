package upload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProxySeetings {
	
	public class ProxySettings {  
		   
		  WebDriver driver;  
		    String serverIP="192.168.1.2";  
		String port="8080";    
		  
		@BeforeTest  
		    public void setUpDriver() {  
		    FirefoxProfile profile = new FirefoxProfile();  
		    profile.setPreference("network.proxy.type",1);  
		    profile.setPreference("network.proxy.ftp",serverIP);  
		    profile.setPreference("network.proxy.http",serverIP);  
		    profile.setPreference("network.proxy.socks",serverIP);  
		    profile.setPreference("network.proxy.ssl",serverIP);  
		    profile.setPreference("network.proxy.ftp_port",port);  
		    profile.setPreference("network.proxy.http_port",port);  
		    profile.setPreference("network.proxy.socks_port",port);  
		    profile.setPreference("network.proxy.ssl_port",port);  
		    driver = new FirefoxDriver(profile);  
		    }  
		     
		     
		   @Test  
		   public void start() throws IOException{  
		    driver.get("https://www.bwin.com/");  
		    driver.findElement(By.id("username")).sendKeys("MyUserName");  
		    driver.findElement(By.id("password")).sendKeys("MyTestPassword");  
		    driver.findElement(By.name("submit")).click();  
		   }  
		     
		  
		}  

}
