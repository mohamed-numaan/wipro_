package seleniumadvanced;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker_TodayDate{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		WebElement ele_frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(ele_frame);

		WebElement dt_ele = driver.findElement(By.id("datepicker"));
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = today.format(formatter);
		dt_ele.sendKeys(formattedDate);
	}

}
