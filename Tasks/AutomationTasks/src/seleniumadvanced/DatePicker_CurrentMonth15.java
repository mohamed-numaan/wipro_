package seleniumadvanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker_CurrentMonth15 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        WebElement ele_frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(ele_frame);

        WebElement dt_ele = driver.findElement(By.id("datepicker"));
        dt_ele.click();

        driver.findElement(By.xpath("//a[text()='15']")).click();
        System.out.println("Selected date: " + dt_ele.getAttribute("value"));

//        driver.quit();
    }
}
