package runnerCucumber;

import io.cucumber.testng.CucumberOptions;
import baseSetup.GETRequest;


@CucumberOptions(features = "src/test/java/featureCucumber"
        ,glue = {"stepsCucumber"})

public class RunnerTest extends GETRequest {

}
