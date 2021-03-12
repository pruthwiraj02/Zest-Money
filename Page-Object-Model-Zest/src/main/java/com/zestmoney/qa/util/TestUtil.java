package com.zestmoney.qa.util;

import com.zestmoney.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 20;
	
	public static void switchToTab(){
		for(String childTab:driver.getWindowHandles())
	    {
	    	driver.switchTo().window(childTab);
	    }
	}
	
}