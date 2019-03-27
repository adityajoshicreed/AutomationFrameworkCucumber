package Runner;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import driver.DriverFactory;
import driver.DriverManager;


@CucumberOptions(
		features="src/test/resources/features",
		glue={"StepDefination"},
		plugin={"io.qameta.allure.cucumberjvm.AllureCucumberJvm"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

	DriverManager driverManager;
	public WebDriver driver;
	DriverFactory df = new DriverFactory();
	private String browserName = "Chrome";
	
	
	@BeforeMethod
	public void methodSetup(Method method) {
		driverManager = df.getManager(browserName);
		driverManager.setMethodName(method.getName());
		driver = driverManager.getDriver();
	}

	
	@AfterMethod
	public void methodShutDown() {
		driverManager.quitDriver();
	}
	
}
