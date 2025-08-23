package automationtestingtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelloScript {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://www.google.com");
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Selenium WebDriver");
			searchBox.sendKeys(Keys.ENTER);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			String searchResultLocator = "div.MjjYud";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(searchResultLocator)));
			List<WebElement> results = driver.findElements(By.cssSelector(searchResultLocator));
			System.out.println("Number of search results: " + results.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Always use `driver.quit()` to close the browser and end the session.
//			driver.quit();
		}
	}
}