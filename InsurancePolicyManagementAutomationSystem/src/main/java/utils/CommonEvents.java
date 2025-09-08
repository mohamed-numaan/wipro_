package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Common reusable Selenium actions across the framework.
 */
public class CommonEvents {

	private WebDriver driver;

	public CommonEvents(WebDriver driver) {
		this.driver = driver;
	}

	//Navigate to a given URL 
	public void navigateTo(String url) {
		driver.get(url);
	}

	// Click an element 
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	// Type text into an input field 
	public void type(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	// Get text from an element 
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	// Check if element is displayed 
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
