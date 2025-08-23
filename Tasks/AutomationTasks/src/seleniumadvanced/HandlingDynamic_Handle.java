package seleniumadvanced;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamic_Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		try {

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

			// Using contains() 
			WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button[contains(text(),'Start')]"));
			startButton.click();
			WebElement finishText = driver.findElement(By.id("finish"));

			System.out.println(finishText.getText());
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}

	}

}
