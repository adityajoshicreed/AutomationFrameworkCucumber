package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GenerateDriver {

	private WebDriver driver;
	private MissingValidMavenArgument nde = new MissingValidMavenArgument("No Driver Manager Specified");
	private DriverDefine driverDef = new DriverDefine();
	private final Logger log = LogManager.getLogger("Log");
	
	public WebDriver getDriver(String type) throws MissingValidMavenArgument {
		if (type.equals("Chrome")) {
			driver = driverDef.getChrome();
		} else if (type.equals("FireFox")) {
			driver = driverDef.getFireFox();
		} else if (type.equals("Grid")) {
			driver = driverDef.getGrid();
		} else {
			throw nde;
		}
		log.info("Generated '"+type+"' driver successfully.");
		return driver;
	}

	public void driverQuit() {
		log.info("Quited driver successfully.");
		driver.quit();
	}

}
