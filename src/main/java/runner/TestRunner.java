package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/features",
		glue = { "stepDefinition","helper" },
		tags = "@Reg", 
		plugin="json:target/jsonReports/test.json"
		)

public class TestRunner {

}
