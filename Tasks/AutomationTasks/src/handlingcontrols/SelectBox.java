package handlingcontrols;
//All the 3 tasks are executed 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement countryDropdown = driver.findElement(By.tagName("select"));
		Select select = new Select(countryDropdown);
		select.selectByVisibleText("India");
		//validates India.
		String selectedText = select.getFirstSelectedOption().getText();
		if (selectedText.equals("India")) {
			System.out.println("Selected country is India.");
		} else {
			System.out.println("Expected India, got " + selectedText);
		}

		select.selectByIndex(4); 
		System.out.println("Selected by index (5th option): " + select.getFirstSelectedOption().getText());

		// Select by Value
		select.selectByValue("USA");
		System.out.println("Selected by value: " + select.getFirstSelectedOption().getText());

		//print all country
		List<WebElement> allOptions = select.getOptions();
		System.out.println("All countries in dropdown:");
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		//        driver.quit();
	}
}
