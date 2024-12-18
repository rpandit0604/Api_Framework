package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/GooglePlace.feature",
		glue= {"stepDefinations"},
		plugin = {"pretty", "html:target/cucumber.html"})
public class TestRunner {
	
}
