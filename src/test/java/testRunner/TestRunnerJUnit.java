package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = "steps",
		monochrome = false, 
		dryRun = false, 
		plugin = {"pretty", "html:target/cucumber.html" }, 
		snippets = SnippetType.CAMELCASE, 
		publish = false)

public class TestRunnerJUnit{
	
}
