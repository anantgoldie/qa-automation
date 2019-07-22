package com.automation.assignment.runner.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.assignment.constants.AppiumConfig;
import com.automation.assignment.runner.browser.Browser;
import com.automation.assignment.runner.desktop.Calculator;
import com.automation.assignment.utils.AppLogger;

public class Utility {
	public static String getScreenShotLocation(String folderName) {
		String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date(System.currentTimeMillis()));
		String screenShotLocation = System.getProperty("user.home")
				+ "/Desktop/Automation/" + date + "/" + folderName + "/";

		return screenShotLocation;
	}
	
	public static String getScreenshotFileName(int stepCount, String methodName) {
		return "Step" + stepCount + "-" + methodName + ".jpg";
	}
	
	public static void getCalculatorScreenshot(String outputlocation) {


		if (AppiumConfig.CAPTURE_SCREEN) {

			File srcFiler = ((TakesScreenshot) Calculator.session).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFiler, new File(outputlocation));
			} catch (IOException e) {
				AppLogger.LOG.debug(e.getMessage());
			}
		}

	}
	
	public static void getBrowserScreenshot(String outputlocation) {


		if (AppiumConfig.CAPTURE_SCREEN) {

			File srcFiler = ((TakesScreenshot) Browser.session).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFiler, new File(outputlocation));
			} catch (IOException e) {
				AppLogger.LOG.debug(e.getMessage());
			}
		}

	}
}
