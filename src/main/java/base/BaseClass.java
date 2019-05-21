package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClass {

	public WebDriver driver;
	public EventFiringWebDriver eDriver;
	public final Logger log = LogManager.getLogger("Log");

}
