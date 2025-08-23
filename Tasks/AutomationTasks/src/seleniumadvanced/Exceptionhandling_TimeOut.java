package seleniumadvanced;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Exceptionhandling_TimeOut {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slowElement")));
        } catch (TimeoutException e) {
            System.out.println("Handled TimeoutException: Element did not load in time.");
        }

        driver.quit();
    }
}
