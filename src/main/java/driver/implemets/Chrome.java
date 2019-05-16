package driver.implemets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import constants.Constants;
import driver.DriverFactory;

public class Chrome extends DriverFactory{

	@Override
	public WebDriver genDriver() {
		System.setProperty("webdriver.chrome.driver", Constants.chromePath);
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(opt);
		driver.navigate().to(Constants.url);
		return driver;
	}

}
