package seleniumadvanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDynamic_Contains {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        // Using contains() 
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button[contains(text(),'Start')]"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='finish']/h4[contains(text(),'Hello World!')]")
        ));

        System.out.println(finishText.getText());

        driver.quit();
    }
}
