package handlingcontrols;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MutliSelectDropDownMenu {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		WebElement dropdown = driver.findElement(By.id("cars"));

		Select select = new Select(dropdown);
		List<WebElement> allOptions = select.getOptions();
		System.out.println("All options in dropdown:");
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		select.selectByVisibleText("Volvo");
		select.selectByVisibleText("Audi");
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		System.out.println("\nSelected values:");
		for (WebElement selected : selectedOptions) {
			String text = selected.getText();
			System.out.println(text);
			if (text.equals("Volvo") || text.equals("Audi")) {
				System.out.println(text + " is selected correctly.");
			} else {
				System.out.println(text + " is not expected.");
			}
		}

		driver.quit();



	}
}
