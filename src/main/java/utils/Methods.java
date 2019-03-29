package utils;

import org.openqa.selenium.By;

import base.BaseClass;

public class Methods {

	private BaseClass base;
	
	public Methods(BaseClass base) {
		this.base = base;
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
}
