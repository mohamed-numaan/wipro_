package handlingcontrols;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormFillSubmit {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();


		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");


		driver.findElement(By.name("firstname")).sendKeys("Mark");
		driver.findElement(By.name("lastname")).sendKeys("Antony");

		driver.findElement(By.id("sex-0")).click();  


		driver.findElement(By.id("exp-2")).click();  

		driver.findElement(By.id("profession-1")).click(); 

		WebElement continentDropdown = driver.findElement(By.id("continents"));
		Select select = new Select(continentDropdown);
		select.selectByVisibleText("Asia");

		driver.findElement(By.id("submit")).click();

		String pageSource = driver.getPageSource();
		if (pageSource.contains("Form submitted successfully") || pageSource.contains("success")) {
			System.out.println("Form submitted successfully!");
		} else {
			System.out.println("Submission message not found.");
		}

		//        driver.quit();
	}
}
