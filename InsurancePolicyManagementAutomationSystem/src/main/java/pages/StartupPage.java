package pages;

import org.openqa.selenium.WebDriver;
import utils.CommonEvents;

public class StartupPage {

    protected WebDriver driver;
    protected CommonEvents commonEvents;

    public StartupPage(WebDriver driver) {
        this.driver = driver;
        this.commonEvents = new CommonEvents(driver);
    }

    // Navigate to given URL /
    public void navigateToUrl(String url) {
        commonEvents.navigateTo(url);
    }

    // Get current page title /
    public String getPageTitle() {
        return driver.getTitle();
    }
}
