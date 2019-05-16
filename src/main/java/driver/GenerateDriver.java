package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import driver.implemets.Chrome;
import driver.implemets.FireFox;
import driver.implemets.Grid;

public class GenerateDriver {

	private WebDriver driver;
	private MissingValidMavenArgument nde = new MissingValidMavenArgument("No Driver Manager Specified");
	private final Logger log = LogManager.getLogger("Log");
	
	public WebDriver getDriver(String type) throws MissingValidMavenArgument {
		if (type.equals("Chrome")) {
			driver = new Chrome().genDriver();
		} else if (type.equals("FireFox")) {
			driver = new FireFox().genDriver();
		} else if (type.equals("Grid")) {
			driver = new Grid().genDriver();
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
