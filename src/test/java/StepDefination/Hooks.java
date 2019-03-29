package StepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import base.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;
import driver.DriverManager;
import driver.EventListener;
import io.qameta.allure.Attachment;

public class Hooks extends BaseClass{
	
	DriverManager driverManager;
//	public WebDriver driver;
	DriverFactory df = new DriverFactory();
	private String browserName = "Chrome";
//	public EventFiringWebDriver eDriver;
	public EventListener handle;
	private BaseClass base;
	
	public Hooks(BaseClass base) {
		this.base = base;
	}

	@Before
	public void generateDriver() {
		driverManager = df.getManager(browserName);
		driver = driverManager.getDriver();
		base.eDriver=new EventFiringWebDriver(driver);
		handle = new EventListener();
		base.eDriver.register(handle);
	}

	@After
	public void closeDriver(Scenario sc) {
		if(sc.isFailed()) {
			saveScreenshot();
		}
		driverManager.quitDriver();
//		base.driver.quit();
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot() {
		return ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.BYTES);
	}
	


}
