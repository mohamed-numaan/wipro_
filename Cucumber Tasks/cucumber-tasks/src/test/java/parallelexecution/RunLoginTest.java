package parallelexecution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/login.feature",
		glue = "steps",
				plugin = {"pretty", "html:target/cucumber-reports.html"}
		)
public class RunLoginTest extends AbstractTestNGCucumberTests {
}
