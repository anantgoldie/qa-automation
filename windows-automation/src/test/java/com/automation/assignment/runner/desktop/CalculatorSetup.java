package com.automation.assignment.runner.desktop;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automation.assignment.constants.AppiumConfig;
import com.automation.assignment.utils.AppLogger;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

/**
* This class setup the drivers for the window calculator.
*
* @author  anantchoubey
* @version 1.0
* @since   2019-JUL-22 
* 
*/

public class CalculatorSetup {

	@BeforeSuite
	public void beforeSuite() {

		try {

			AppLogger.LOG.info("Creating drivers!!!");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe"); // to get app appid, powershell - Get-AppxPackage *<app_name>
			capabilities.setCapability(CapabilityType.PLATFORM_NAME, AppiumConfig.WINDOWS_PLATFORM);
			capabilities.setCapability("deviceName", "PC");

			Calculator.session = new WindowsDriver<WindowsElement>(new URL(AppiumConfig.APPIUM_HOST_URL), capabilities);
			Calculator.session.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            Assert.assertNotNull(Calculator.session.findElementByAccessibilityId("CalculatorResults"));

			AppLogger.LOG.info("Drivers created!!!");
		} catch (MalformedURLException e) {
			AppLogger.LOG.info("Unable to connect with appium " + e.getMessage());
		}finally {
        }

	}

	@AfterSuite
	public void afterSuite() {
        if (Calculator.session != null) {
        	Calculator.session.quit();
        }
        Calculator.session = null;
		AppLogger.LOG.info("Destroying drivers!!!");
	}

}
