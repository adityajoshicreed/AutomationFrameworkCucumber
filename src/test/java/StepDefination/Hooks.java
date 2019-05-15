package StepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import base.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.EventListener;
import driver.GenerateDriver;
import driver.MissingValidMavenArgument;
import io.qameta.allure.Attachment;

public class Hooks extends BaseClass{
	
	private GenerateDriver gd = new GenerateDriver();
	private String browserName = "Chrome";
	private EventListener handle;
	private BaseClass base;
	private final Logger log = LogManager.getLogger("Log");
	
	public Hooks(BaseClass base) {
		this.base = base;
	}

	@Before
	public void generateDriver(Scenario sc) throws MissingValidMavenArgument {
		driver = gd.getDriver(browserName);
		base.eDriver=new EventFiringWebDriver(driver);
		handle = new EventListener();
		base.eDriver.register(handle);
	}

	@After
	public void closeDriver(Scenario sc) {
		if(sc.isFailed()) {
			saveScreenshot(driver);
			log.info("Added Screenshot to report.");
			gd.driverQuit();
		}
		gd.driverQuit();
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
}
