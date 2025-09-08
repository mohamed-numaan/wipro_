package testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ExcelReader;
import utils.ExtentReport;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Tests {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	ExtentReports extent;
	ExtentTest test;


	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReport.getExtentReports();
	}

	@BeforeClass
	public void setup() {
		WebDriver localDriver = new ChromeDriver();
		driver.set(localDriver);
		getDriver().manage().window().maximize();
		getDriver().get("C:\\Users\\shafi\\eclipse-workspace\\InsurancePolicyManagementSystem\\src\\main\\resources\\LoginPage\\index.html"); 
	}
	@Test(priority = 1)
	public void loginInvalidTest() {
		test = extent.createTest("Invalid Login Test");
		WebElement element = getDriver().findElement(By.id("username"));
		element.sendKeys("WrongUser");
		WebElement element2 = getDriver().findElement(By.id("password"));
		element2.sendKeys("WrongPass");
		getDriver().findElement(By.cssSelector("#login-form button")).click();

		String msg = getDriver().findElement(By.id("login-message")).getText();
		Assert.assertEquals(msg, "Invalid username or password.");
		getDriver().findElement(By.id("username")).clear();
		getDriver().findElement(By.id("password")).clear();
		test.pass("Proper error shown for invalid login.");
	}
	@Test(priority = 2)
	public void loginValidTest() {
		test = extent.createTest("Valid Login Test");

		getDriver().findElement(By.id("username")).sendKeys("Mohamed Numaan");
		getDriver().findElement(By.id("password")).sendKeys("Numaan123");
		getDriver().findElement(By.cssSelector("#login-form button")).click();

		WebElement welcomeMsg = getDriver().findElement(By.id("welcome-user"));
		Assert.assertTrue(welcomeMsg.getText().contains("Mohamed Numaan"));
		test.pass("Login successful with valid credentials.");
	}
	@Test(priority = 3, dataProvider = "policyData")
	public void policyCreationTest(String type, String name, String age, String coverage, String duration) {
		test = extent.createTest("Policy Creation Test for " + type);

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		getDriver().findElement(By.id("policy-type")).sendKeys(type);
		getDriver().findElement(By.id("policy-name")).sendKeys(name);
		getDriver().findElement(By.id("policy-age")).sendKeys(age);
		getDriver().findElement(By.id("policy-coverage")).sendKeys(coverage);
		getDriver().findElement(By.id("policy-duration")).sendKeys(duration); 

		getDriver().findElement(By.cssSelector("#policy-form button[type='submit']")).click();

		getDriver().findElement(By.id("card-number")).sendKeys("101010101010");
		getDriver().findElement(By.id("expiry-month")).sendKeys("12");
		getDriver().findElement(By.id("expiry-year")).sendKeys("2026");
		getDriver().findElement(By.id("cvc")).sendKeys("114");
		getDriver().findElement(By.xpath("//*[@id='payment-form']/button")).click();

		WebElement modal = getDriver().findElement(By.id("payment-modal"));
		Assert.assertTrue(modal.isDisplayed());
		test.pass("Policy creation flow triggered successfully for " + type);
		wait.until(ExpectedConditions.invisibilityOf(modal));
	}
	
	@Test(priority = 4)
	public void premiumCalculationTest() {
		test = extent.createTest("Premium Calculation Test");

		getDriver().findElement(By.id("policy-type")).sendKeys("Health Insurance");
		getDriver().findElement(By.id("policy-name")).sendKeys("Numaan");
		getDriver().findElement(By.id("policy-age")).sendKeys("30");
		getDriver().findElement(By.id("policy-coverage")).sendKeys("50000");
		getDriver().findElement(By.id("policy-duration")).sendKeys("1"); 
		getDriver().findElement(By.id("calculate-premium-btn")).click();

		String premiumResult = getDriver().findElement(By.id("premium-result")).getText();
		Assert.assertTrue(premiumResult.contains("Estimated Premium"));
		test.pass("Premium calculated correctly.");
	}


	@Test(priority = 5)
	public void claimsProcessingTest() {
		test = extent.createTest("Claims Processing Test");

		getDriver().findElement(By.id("claim-policy-number")).sendKeys(""); //Add the policyID after creation of any policyID
		getDriver().findElement(By.id("claim-description")).sendKeys("Hospitalization due to accident");
		getDriver().findElement(By.cssSelector("#claims-form button")).click();

		String status = getDriver().findElement(By.id("claim-status")).getText();
		Assert.assertTrue(status.contains("Claim submitted successfully"));
		test.pass("Claim submitted successfully.");
	}

	@Test(priority = 6)
	public void policyRenewalTest() {
		test = extent.createTest("Policy Renewal Test");

		WebElement renewBtn = getDriver().findElement(By.cssSelector(".renew-btn"));
		renewBtn.click();

		WebElement modal = getDriver().findElement(By.id("payment-modal"));
		Assert.assertTrue(modal.isDisplayed());
		test.pass("Renewal payment modal opened successfully.");
	}

	@Test(priority = 7)
	public void Logout() {
	    test = extent.createTest("Logout Test");

	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	    // First wait for any modal to disappear if it’s present
	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("payment-modal")));
	    } catch (TimeoutException e) {
	        System.out.println("No modal found, proceeding with logout.");
	    }

	    WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout-btn")));
	    logoutBtn.click();

	    // Verify login form appears again
	    WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
	    Assert.assertTrue(loginForm.isDisplayed(), "Login form not displayed after logout!");
	    test.pass("Logged out successfully.");
	}


	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}

	@AfterSuite
	public void closeReport() {
		extent.flush();
	}

	@DataProvider
	public Object[][] policyData() {
		// Example: reading from Excel using ExcelReader
		ExcelReader reader = new ExcelReader("src/test/java/policyData.xlsx");
		return reader.getSheetData("Sheet1");
	}
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				String screenshotPath = "screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";
				File destination = new File(screenshotPath);
				FileUtils.copyFile(source, destination);

				// Attach to Extent report
				test.fail("Test Failed. Screenshot attached.")
				.addScreenCaptureFromPath(screenshotPath);

			} catch (Exception e) {
				test.fail("Failed to capture screenshot: " + e.getMessage());
			}
		}
	}
}
