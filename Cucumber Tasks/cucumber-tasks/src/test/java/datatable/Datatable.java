package datatable;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;

public class Datatable {
    WebDriver driver;

    @Given("User is on Login Page")
    public void user_is_on_login() {
    	System.out.println("Opening Login Page...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("User logs in with") 
    public void user_logs_in_with(DataTable dataTable) { 
    List<Map<String, String>> users = dataTable.asMaps(); 
    for (Map<String, String> user : users) { 
    driver.findElement(By.id("username")).clear(); 
    driver.findElement(By.id("username")).sendKeys(user.get("username")); 
    driver.findElement(By.id("password")).clear(); 
    driver.findElement(By.id("password")).sendKeys(user.get("password")); 
    driver.findElement(By.id("submit")).click();
    
    try {
        if (driver.findElement(By.id("logoutBtn")).isDisplayed()) { // assuming logoutBtn appears on success
            System.out.println("Login Success for: " + user.get("username"));
        } else {
            System.out.println("Login Failed for: " + user.get("username"));
        }
    } catch (Exception e) {
        System.out.println("Login Failed for: " + user.get("username"));
    }
    } 
    }

    @Then("Verify login results")
    public void login_should() {
    	 System.out.println("Login verified");
//        driver.quit();
    }
}
