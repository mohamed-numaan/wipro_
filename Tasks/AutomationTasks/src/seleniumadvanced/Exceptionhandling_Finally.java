package seleniumadvanced;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptionhandling_Finally {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/");
            driver.findElement(By.id("nonExistingElement"));
        } catch (NoSuchElementException e) {
            System.out.println("Handled NoSuchElementException: Element not found.");
        } finally {
            driver.quit();
            System.out.println("Browser closed in finally block.");
        }
    }
}
