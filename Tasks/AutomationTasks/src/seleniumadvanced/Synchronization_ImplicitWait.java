package seleniumadvanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronization_ImplicitWait {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();
        
        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
       Thread.sleep(12000);
        // Check if it is enabled
        if (inputBox.isEnabled()) {
            System.out.println("Input box is enabled.");
        } else {
            System.out.println("Input box is still disabled.");
        }

        driver.quit();
    }
}
