package google;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/google.feature",  
    glue = {"google"},                      
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
