package seleniumadvanced;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptionhandling_Try {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        try {
            driver.findElement(By.id("nonExistingElement"));
        } catch (NoSuchElementException e) {
            System.out.println("Handled NoSuchElementException: Element not found.");
        }

        driver.quit();
    }
}
