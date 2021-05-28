package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun=false, 
		features= {"src/test/java/features"}, 
		glue= {"servicenow_selfdef","servicenow_hooks"},
		monochrome=true
		)

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}