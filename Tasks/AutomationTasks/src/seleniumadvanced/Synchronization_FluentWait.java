package seleniumadvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Synchronization_FluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            // Click Remove button
            WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
            removeBtn.click();

            // FluentWait: max 15s, poll every 1s
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);

            // Wait until message is present
            WebElement message = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("message"))
            );

            System.out.println("Message displayed: " + message.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
