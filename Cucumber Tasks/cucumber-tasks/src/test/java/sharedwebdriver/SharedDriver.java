package sharedwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedDriver { 
	private WebDriver driver; 
	
	public SharedDriver() { 
		driver = new ChromeDriver(); 
	} 
	public WebDriver getDriver() { 
		return driver; 
	} 
}