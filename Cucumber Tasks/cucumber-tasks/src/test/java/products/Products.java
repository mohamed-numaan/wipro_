package products;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Products {

	WebDriver driver;


	@Given("User is on Search Page")
	public void user_is_on_search_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@When("User searches for") 
	public void user_searches_for(List<String> items) { 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		for (String item : items) { 
			driver.findElement(By.name("q")).clear(); 
			driver.findElement(By.name("q")).sendKeys(item);
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("Searched: " + item); 
		
	        try {
	            Thread.sleep(2000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        try {
	            WebElement topResult = driver.findElement(By.cssSelector("h3"));
	            System.out.println("Top result for '" + item + "': " + topResult.getText());
	        } catch (Exception e) {
	            System.out.println("No results found for: " + item);
	        }

	        driver.navigate().back();
		}
	}

	@Then("Products should be displayed")
	public void products_should_be_displayed() {
		System.out.println();
		//	        driver.quit();
	}
}