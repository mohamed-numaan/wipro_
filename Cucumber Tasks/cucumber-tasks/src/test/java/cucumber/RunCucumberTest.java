package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions( 
		features = "src/test/resources/features", 
		glue = {"stepdefinitions", "datatable","google","steps","products" }, 
		plugin = { 
				"pretty", 
				"html:target/cucumber-html-report", 
				"json:target/cucumber.json", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		}, 
		monochrome = true 
		) 
public class RunCucumberTest {}
