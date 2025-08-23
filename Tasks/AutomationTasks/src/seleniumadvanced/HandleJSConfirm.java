package seleniumadvanced;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJSConfirm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text is: " + alert.getText());
		alert.dismiss();

		String result = driver.findElement(By.id("result")).getText();
		System.out.println("Result after dismiss: " + result);


	}

}
