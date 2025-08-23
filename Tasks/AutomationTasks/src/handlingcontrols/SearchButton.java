package handlingcontrols;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium WebDriver", Keys.ENTER);

		String pageSource = driver.getPageSource();
		if (pageSource.contains("Selenium")) {
			System.out.println("Selenium found in results.");
		} else {
			System.out.println("Selenium not found in results.");
		}
	}

}
