package seleniumadvanced;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/tables");
		WebElement table = driver.findElement(By.id("table1"));

		List<WebElement> lastname = driver.findElements(By.xpath("//*[@id='table1']//tbody/tr/td[1]"));

		List<String> originalOrder = new ArrayList<>();
		for(WebElement e : lastname) {
			originalOrder.add(e.getText().trim());
		}

		List<String> sortedOrder = new ArrayList<>(originalOrder);
		Collections.sort(sortedOrder);

		System.out.println("Sorted Last Names: " + sortedOrder);
	}
}
