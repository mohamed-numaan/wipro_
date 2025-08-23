package seleniumadvanced;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_PrintEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/tables");
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> emailList = driver.findElements(
				By.xpath("//*[@id='table1']//tbody/tr/td[3]"));
		System.out.println("----------------------------------");
		System.out.println("Emails of all users in Table1:");
		for (WebElement email : emailList) {
			System.out.println("Email: "+email.getText());
		}
		System.out.println("------------------------------------");
		WebElement table1 = driver.findElement(By.id("table2"));
		List<WebElement> emailList1 = driver.findElements(By.xpath("//*[@id='table2']//tbody/tr/td[3]"));
		System.out.println("Emails of all users in Table2:");
		for(WebElement email1: emailList1) {
			System.out.println("Email:" +email1.getText());
		}
	}
	//		driver.quit();

}


