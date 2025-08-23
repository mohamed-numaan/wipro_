package handlingcontrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox_Radio {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");

        // Checkboxes 
        WebElement monday = driver.findElement(By.id("monday"));
        if (!monday.isSelected()) {
            monday.click();
        }
        System.out.println("Monday selected: " + monday.isSelected()); 

        String[] days = {"monday", "wednesday", "friday"};
        for (String day : days) {
            WebElement checkbox = driver.findElement(By.id(day));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            System.out.println(day + " selected: " + checkbox.isSelected());
        }
        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        long selectedCount = allCheckboxes.stream().filter(WebElement::isSelected).count();
        System.out.println("Total selected checkboxes: " + selectedCount);

        // Radio Buttons
        WebElement female = driver.findElement(By.id("female"));
        female.click();
        System.out.println("Female selected: " + female.isSelected());

        WebElement male = driver.findElement(By.id("male"));
        male.click();
        System.out.println("Male selected: " + male.isSelected());
        female.click(); 
        System.out.println("Male selected after switch: " + male.isSelected());
        System.out.println("Female selected after switch: " + female.isSelected());
        Thread.sleep(2000);
        driver.quit();
    }
}
