package Cucumber.RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/StockValues.feature" , 
				 glue = {"classpath:Cucumber.stepDefinition"}, 
				 monochrome = true,
				 //plugin = { "pretty","json:target/SearchFeatureRunner.json"})
				 plugin = {"pretty","html:target/cucumber/report.html"})
public class StockRunnerClass extends AbstractTestNGCucumberTests 
{
	
	
}