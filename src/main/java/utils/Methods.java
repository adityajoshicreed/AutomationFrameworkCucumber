package utils;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;

import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Methods {

	private BaseClass base;

	private WebDriverWait wait;
	
	public Methods(BaseClass base) {
		this.base = base;
		wait = new WebDriverWait(base.eDriver, 10);
	}
	
	public void navigateTo(String url) {
		base.eDriver.get(url);
	}
	
	public void click(By element) {
		base.eDriver.findElement(element).click();
	}
	
	public void input(By element,String value) {
		base.eDriver.findElement(element).sendKeys(value);
	}

	public void waitForVisible(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public String getAttributeValue(By by, String attribute) {
		return base.eDriver.findElement(by).getAttribute(attribute);
	}

	public void openANewTab() {
		((JavascriptExecutor)base.eDriver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(base.eDriver.getWindowHandles());
		base.eDriver.switchTo().window(tabs.get(1));
	}

	public String generateTotp(String key) {
		Totp top = null;
		try {
			top = new Totp(key);
		}
		catch(Exception ex) {
			base.log.debug(ex);
		}
		return top.now();
	}

	public boolean webElementPresence(By by) {
		List<WebElement> element = base.eDriver.findElements(by);
		return !element.isEmpty();
	}
}
