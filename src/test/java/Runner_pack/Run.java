package Runner_pack;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "src/test/java/Feature", 
		glue = "StepDefination_pack", 
		plugin = { "pretty","pretty",
		        "html:target/cucumber-reports/cucumber.html",
		        "json:target/cucumber-reports/cucumber.json",
		        "junit:target/cucumber-reports/cucumber.xml" }, 
		monochrome = true,
		tags = "@test1"

)
public class Run extends AbstractTestNGCucumberTests {
	
	


}

