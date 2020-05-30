package com.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Elions {
	WebDriver driver;
	public Elions() {
		
	}
	
	private void initDriver() {
		System.setProperty("webdriver.ie.driver", "drivers/32/IEDriverServer.exe");
		DesiredCapabilities cap = new DesiredCapabilities();  
		//cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
         cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //disable protected mode settings
         cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); //disable protected mode settings
         cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true); //disable protected mode settings
         WebDriver driver = new InternetExplorerDriver(cap);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
