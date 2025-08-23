package automationtestingtask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationTask {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Login 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin"); //By name

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		WebElement login = driver.findElement(By.className("orangehrm-login-button"));
		login.click(); //By class name

		//PIM Add employee
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();

		//Add details for the employee
		//name
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("John"); //first name

		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Smith"); //last name

		WebElement emp_id = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
		emp_id.sendKeys("224"); //employee id

		WebElement photo = driver.findElement(By.xpath("//input[@type='file']"));
		String filepath = System.getProperty("user.dir") + "\\\\36001AlloraGreyroom_533x.jpg";
		photo.sendKeys(filepath); //add photo

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click(); 
		Thread.sleep(8000);
		//save
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		//logout
		System.out.println("Success");
	}

}
