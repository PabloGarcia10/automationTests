package testRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		snippets = SnippetType.CAMELCASE,
		publish = false)
public class TestRunnerTestNg extends AbstractTestNGCucumberTests {

	public static void main(String[] args) {

	}

	@BeforeClass
	public static void beforeClass() {

	}

	@AfterClass
	public static void afterClass() {

	}

}
