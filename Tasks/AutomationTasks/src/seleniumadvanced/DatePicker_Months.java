package seleniumadvanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker_Months {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		WebElement ele_frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(ele_frame);

		WebElement dt_ele = driver.findElement(By.id("datepicker"));
		dt_ele.click();
		//clicking twice to go next month
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		driver.findElement(By.xpath("//a[@title='Next']")).click();

		driver.findElement(By.xpath("//a[text()='19']")).click(); //19/10/2025
		System.out.println("Selected date: " + dt_ele.getAttribute("value"));
		//        driver.quit();
	}
}
