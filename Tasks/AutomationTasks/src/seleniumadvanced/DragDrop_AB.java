package seleniumadvanced;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop_AB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		WebElement columnA = driver.findElement(By.id("column-a"));
		WebElement columnB = driver.findElement(By.id("column-b"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(columnA, columnB).perform();

		// Verify swap
		String headerA = columnA.findElement(By.tagName("header")).getText();
		String headerB = columnB.findElement(By.tagName("header")).getText();

		System.out.println("After Drag A→B:");
		System.out.println("Column A Header: " + headerA);
		System.out.println("Column B Header: " + headerB);

	}

}
