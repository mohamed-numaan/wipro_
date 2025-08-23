package seleniumadvanced;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_PrintAll {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/tables");

		WebElement table = driver.findElement(By.id("table1"));

		List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));
		for (WebElement header : headers) {
			System.out.print(header.getText() + " | ");
		}
		System.out.println();

		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}

		driver.quit();
	}
}
