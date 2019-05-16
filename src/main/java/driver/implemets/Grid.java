package driver.implemets;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Constants;
import driver.DriverFactory;

public class Grid extends DriverFactory{

	public final String URL_GRID = "http://192.168.6.65:4444/wd/hub";
	
	@Override
	public WebDriver genDriver() {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, org.openqa.selenium.Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(new URL(URL_GRID), options);
			driver.get(Constants.url);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return driver;
	}

}
