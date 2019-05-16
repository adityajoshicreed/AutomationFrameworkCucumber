package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverFactory {

	protected WebDriver driver;
	protected abstract WebDriver genDriver();
	
}
