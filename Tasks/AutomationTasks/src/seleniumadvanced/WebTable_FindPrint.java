package seleniumadvanced;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_FindPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/tables");
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']//tbody/tr"));
		for (WebElement row : rows) {
			// get Last Name (first column text)
			String lastName = row.findElement(By.xpath("./td[1]")).getText();

			if (lastName.equals("Smith")) {
				String dueAmount = row.findElement(By.xpath("./td[4]")).getText();
				System.out.println("Due amount for Smith: " + dueAmount);
				break; 
			}
		}
	}
}

