package seleniumadvanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization_ExplicitWait {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       //explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enableButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/button"))
        );
        enableButton.click();
        
        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        if (inputBox.isEnabled()) {
            System.out.println("Input box is enabled using Explicit Wait.");
        } else {
            System.out.println("Input box is still disabled.");
        }

        driver.quit();
    }
}
