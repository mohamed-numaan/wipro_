package automationtestingtask;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleValidation{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		String expectedTitle = "OrangeHRM";

		try {

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://opensource-demo.orangehrmlive.com/");
			String actualTitle = driver.getTitle();
			WebElement username = driver.findElement(By.name("username"));
			username.sendKeys("Admin");

			WebElement passowrd = driver.findElement(By.name("password"));
			passowrd.sendKeys("admin123");

			WebElement login = driver.findElement(By.cssSelector("button[type ='submit']"));
			login.click();



			if (actualTitle.equals(expectedTitle)) {
				System.out.println("Login successful. Page title: " + actualTitle);
			} else {
				System.out.println("Login failed. Expected Title: " + expectedTitle);
			}

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
//			driver.quit();
		}
	}
}
