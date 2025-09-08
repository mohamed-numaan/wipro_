package com.insurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PoliciesPage {

    private WebDriver driver;

    public PoliciesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get all expired policies
    public List<WebElement> getExpiredPolicies() {
        return driver.findElements(By.xpath("//tr[td[text()='Expired']]"));
    }

    // Click the Renew button for a specific policy row
    public void renewPolicy(WebElement policyRow) {
        policyRow.findElement(By.xpath(".//button[text()='Renew']")).click();
    }

    // Fetch policy ID
    public String getPolicyId(WebElement policyRow) {
        return policyRow.findElement(By.xpath("./td[1]")).getText();
    }
}
