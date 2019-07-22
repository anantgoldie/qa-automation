package com.automation.assignment.runner.desktop;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.assignment.runner.utils.Utility;
import com.automation.assignment.utils.AppLogger;

public class CalculatorTask2 {

	private final String screenShotLocation = Utility.getScreenShotLocation("Calculator");
	private int stepCount = 0;
	private String methodName = "";
	
	@BeforeMethod
	public void handleTestMethodName(Method method) {
		methodName = method.getName();
		AppLogger.LOG.info("Executing test : " + methodName);
	}
	
	@Test
	public void checkWindowName() {
		Assert.assertEquals(Calculator.session.findElementByAccessibilityId("WINDOW_HEADER").getText(), Calculator.EXPECTED_WINDOW_TITLE);
		
	}
	
	@Test
	public void checkInitialValue() {
		Assert.assertEquals(getResults().getText(), Calculator.zero);
		
	}
	
	@Test
	public void add() {
		Calculator.session.findElementByName(Calculator.five).click();
		Calculator.session.findElementByName(Calculator.add).click();
		Calculator.session.findElementByName(Calculator.five).click();
		Calculator.session.findElementByName(Calculator.equals).click();
        Assert.assertEquals(getResults().getText(), "11");
        
        Utility.getCalculatorScreenshot(screenShotLocation + Utility.getScreenshotFileName(++stepCount, methodName));
	}
	
	private WebElement getResults() {
		return Calculator.session.findElementByAccessibilityId("CalculatorResults");
	}

}
