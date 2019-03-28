package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/features", glue = { "StepDefination" }, plugin = {
		"io.qameta.allure.cucumberjvm.AllureCucumberJvm" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
