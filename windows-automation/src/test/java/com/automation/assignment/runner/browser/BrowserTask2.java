package com.automation.assignment.runner.browser;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.assignment.runner.utils.Utility;
import com.automation.assignment.utils.AppLogger;

public class BrowserTask2 {

	private final String screenShotLocation = Utility.getScreenShotLocation("Browser");
	private int stepCount = 0;
	private String methodName = "";
	
	@BeforeMethod
	public void handleTestMethodName(Method method) {
		methodName = method.getName();
		AppLogger.LOG.info("Executing test : " + methodName);
	}
	
	@Parameters({ "google-url" })
	@Test
	public void navigateURL(String url) {
		Browser.driver.get(url);
	}
	
	@Parameters({ "tesla-car" })
	@Test
	public void searchText(String searchText) {
		WebElement element = Browser.driver.findElement(By.name("q"));
	    element.sendKeys(searchText);
	    
		Utility.getBrowserScreenshot(screenShotLocation + Utility.getScreenshotFileName(++stepCount, methodName));
	}
	
	@Parameters({ "wolkswagen-car" })
	@Test
	public void checkResults(String car) {
		List<WebElement> list = Browser.driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
	    
		boolean actual = false;
		
		for (WebElement webElement : list) {
			
			if(webElement.getText().toLowerCase().contains(car)) {
				actual = true;
				break;
			}
			
		}
		
		Assert.assertEquals(actual, true);
		
		Utility.getBrowserScreenshot(screenShotLocation + Utility.getScreenshotFileName(++stepCount, methodName));
	}

}
