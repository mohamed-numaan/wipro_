package seleniumadvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandlingWindows_Switch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Child window title: " + driver.getTitle());
            }
        }

        driver.quit();
    }
}
