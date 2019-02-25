package com.crm.qa.util;

import com.crm.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends Base {

	public static final long PAGE_LOAD_TIMOUT = 20;
	public static final long IMPLICIT_WAIT = 10;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	/* Explicit wait */

	public void explicitWait(WebDriver driver, WebElement element, int timeout){

		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}


}
