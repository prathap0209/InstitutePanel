package com.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class DriverFactory {

	public static AndroidDriver createDriver(String deviceName,String udid,String appiumUrl, int systemPort) throws Exception {

	    UiAutomator2Options options = new UiAutomator2Options();

	    options.setPlatformName("Android"); 
	    options.setDeviceName(deviceName); 
	    options.setUdid(udid); 
	    options.setAutomationName("UiAutomator2"); 
	    options.setAppPackage("com.corzaar.app");
	    options.setAppActivity(".MainActivity"); 
	    options.setNoReset(false); 

	    options.setSystemPort(systemPort); 
	    return new AndroidDriver( new URL(appiumUrl), options);
	}	
}
