package parallelexecution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/products.feature",
		glue = {"products"},
		plugin = {"pretty", "html:target/cucumber-reports.html"}
		)
public class RunProductTest extends AbstractTestNGCucumberTests {
}
