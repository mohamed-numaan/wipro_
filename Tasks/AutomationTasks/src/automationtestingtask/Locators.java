package automationtestingtask;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin"); //Byname

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		WebElement login = driver.findElement(By.className("orangehrm-login-button"));
		login.click(); //Byclassname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total hyperlinks on dashboard: " + allLinks.size());

		// using Absolute XPath
		WebElement adminMenuAbs = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		adminMenuAbs.click();
		//  using Relative XPath
		WebElement adminMenuRel = driver.findElement(By.xpath("//span[text()='Admin']"));
		adminMenuRel.click();

		//using CSS selector;
		driver.findElement(By.xpath("//span[text()='Admin']")).click();

	}
}

