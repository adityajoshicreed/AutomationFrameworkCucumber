package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	protected abstract void startBrowser();
	
	public void quitDriver() {
		driver.quit();
	}
		
	public WebDriver getDriver() {
		startBrowser();
		return driver;
	}
	
}