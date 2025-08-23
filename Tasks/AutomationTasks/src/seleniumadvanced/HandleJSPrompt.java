package seleniumadvanced;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJSPrompt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();

		Alert alrt = driver.switchTo().alert();
		alrt.sendKeys("Mohamed Numaan");
		alrt.accept();
	}
}
