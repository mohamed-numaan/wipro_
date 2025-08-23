package google;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {

	WebDriver driver;

	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	@When("User searches for {string}")
	public void user_seatches_for(String query) {
		driver.findElement(By.name("q")).sendKeys(query);
		driver.findElement(By.name("q")).submit();
	}

	@Then("Results should contain {string}")
	public void results_should_contain(String keyword) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
		List<WebElement> results = driver.findElements(By.cssSelector("h3"));
		boolean found = results.stream().anyMatch(e -> e.getText().toLowerCase().contains(keyword.toLowerCase()));

		Assert.assertTrue(found, "Keyword not found in search results: " + keyword);

	}
}
