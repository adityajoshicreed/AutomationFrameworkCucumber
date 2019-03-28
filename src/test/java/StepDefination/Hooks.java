package StepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;
import driver.DriverManager;
import driver.EventListener;
import io.qameta.allure.Attachment;

public class Hooks{
	
	DriverManager driverManager;
	public WebDriver driver;
	DriverFactory df = new DriverFactory();
	private String browserName = "Chrome";
	public static EventFiringWebDriver eDriver;
	public EventListener handle;

	@Before
	public void generateDriver() {
		driverManager = df.getManager(browserName);
		driver = driverManager.getDriver();
		eDriver=new EventFiringWebDriver(driver);
		handle = new EventListener();
		eDriver.register(handle);
	}

	@After
	public void closeDriver(Scenario sc) {
		if(sc.isFailed()) {
			saveScreenshot();
		}
		driverManager.quitDriver();
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	


}
