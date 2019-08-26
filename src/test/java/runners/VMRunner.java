package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber/cucumber.json",
                "junit:target/cucumber/cucumber.xml",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "stepDefs",
        dryRun = false

)
public class VMRunner {
}
