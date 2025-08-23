package handlingcontrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TextFieldEntry {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	
		driver.get("https://www.w3scools.com/html/html_forms.asp");
		driver.manage().window().maximize();
		
		WebElement firstName = driver.findElement(By.id("fname"));
		WebElement lastName = driver.findElement(By.id("lname"));

		firstName.clear();
		firstName.sendKeys("John");
		lastName.clear();
		lastName.sendKeys("Doe");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		String pageSource = driver.getPageSource();
		if (pageSource.contains("fname=John") && pageSource.contains("lname=Doe")) {
			System.out.println("✅ Task 1 Passed: Data submitted successfully!");
		} else {
			System.out.println("❌ Task 1 Failed: Data mismatch.");
		}
	}
}
