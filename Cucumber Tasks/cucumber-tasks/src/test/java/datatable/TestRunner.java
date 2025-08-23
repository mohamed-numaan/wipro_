package datatable;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/datatable.feature",  
    glue = {"stepdefinitions", "datatable"},                        
    plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
