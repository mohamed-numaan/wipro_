package sharedwebdriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Cucumber options
@CucumberOptions(
        features = "src/test/resources/features/products.feature", 
        glue = {"stepdefinitions", "products"},                         
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests { }

