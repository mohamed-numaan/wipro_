package handlingcontrols;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginButton {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();


		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		WebElement loginBtn = driver.findElement(By.className("orangehrm-login-button"));
		loginBtn.click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("✅ Login successful. Page title: " + actualTitle);
		} else {
			System.out.println("❌ Login failed. Expected Title: " + expectedTitle + ", but got: " + actualTitle);
		}
	}
}
