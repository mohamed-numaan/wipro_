package seleniumadvanced;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization_Message{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");


		driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
		Thread.sleep(5000);

		System.out.println("Checkbox removed successfully!");
		driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();

		Thread.sleep(5000);

		System.out.println("Checkbox added back successfully ");

		driver.quit();
	}
}
