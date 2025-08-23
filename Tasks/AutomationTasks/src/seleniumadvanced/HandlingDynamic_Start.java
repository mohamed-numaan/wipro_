package seleniumadvanced;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDynamic_Start {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//*[@id='start']/button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement helloText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		
		System.out.println(helloText.getText());
	}

}
