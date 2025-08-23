package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;

    @Given("User")
    public void user() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @Then("Login should be {string}")
    public void login_should_be(String status) {
        if (status.equalsIgnoreCase("success")) {
            assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully"));
        } else {
            assertTrue(driver.getPageSource().contains("Your username is invalid") ||
                       driver.getPageSource().contains("Your password is invalid"));
        }
        driver.quit();
    }
}
