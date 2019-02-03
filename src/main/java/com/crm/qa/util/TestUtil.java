package com.crm.qa.util;

import com.crm.qa.base.Base;

public class TestUtil extends Base {

	public static long PAGE_LOAD_TIMOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

}
