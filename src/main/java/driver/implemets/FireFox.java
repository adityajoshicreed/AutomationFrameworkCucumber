package driver.implemets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;
import driver.DriverFactory;

public class FireFox extends DriverFactory{

	@Override
	public WebDriver genDriver() {
		System.setProperty("webdriver.gecko.driver", Constants.firefoxPath);
		driver = new FirefoxDriver();
		driver.navigate().to(Constants.url);
		return driver;
	}

}
