package seleniumadvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingiFrames_PageHeader {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().defaultContent();
        WebElement header = driver.findElement(By.tagName("h3"));
        if (header.isDisplayed()) {
            System.out.println("Page header is visible: " + header.getText());
        }

        driver.quit();
    }
}
