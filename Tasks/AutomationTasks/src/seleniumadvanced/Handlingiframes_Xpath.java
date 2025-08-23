package seleniumadvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingiframes_Xpath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));

        textBox.sendKeys(Keys.CONTROL + "a");
        textBox.sendKeys(Keys.DELETE);
        textBox.sendKeys("Hello Selenium");

        textBox.sendKeys(Keys.CONTROL + "a");
        textBox.sendKeys(Keys.DELETE);
        textBox.sendKeys("Mohamed Numaan");

        driver.switchTo().defaultContent();
        WebElement header = driver.findElement(By.xpath("//h3"));
        if (header.isDisplayed()) {
            System.out.println("Page header is visible: " + header.getText());
        }

        driver.quit();
    }
}
