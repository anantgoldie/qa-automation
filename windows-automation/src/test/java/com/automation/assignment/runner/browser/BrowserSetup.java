package com.automation.assignment.runner.browser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automation.assignment.constants.AppConfig;
import com.automation.assignment.utils.AppLogger;

/**
* This class sets up the drivers for the browser. 
*
* @author  anantchoubey
* @version 1.0
* @since   2019-JUL-22 
* 
*/

public class BrowserSetup {

	@BeforeSuite
	public void beforeSuite() {

		AppLogger.LOG.info("Creating drivers!!!");
		System.setProperty(AppConfig.CHROME_DRIVER_KEY, AppConfig.CHROME_EXE_URL);
		Browser.driver = new ChromeDriver();
		Browser.driver.manage().window().maximize();
		AppLogger.LOG.info("Drivers created!!!");
	}

	@AfterSuite
	public void afterSuite() {
		Browser.driver.quit();
		AppLogger.LOG.info("Destroying drivers!!!");
	}

}
