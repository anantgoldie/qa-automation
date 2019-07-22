package com.automation.assignment.runner.desktop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsElement;

public class Calculator {
	public static AppiumDriver<WindowsElement> session = null;

	public static final String EXPECTED_WINDOW_TITLE = "Calculator";
	
	public static final String zero = "Zero";
	public static final String one = "One";
	public static final String two = "Two";
	public static final String three = "Three";
	public static final String four = "Four";
	public static final String five = "Five";
	public static final String six = "Six";
	public static final String seven = "Seven";
	public static final String eight = "Eight";
	public static final String nice = "Nine";
	
	public static final String equals = "Equals";
	public static final String add = "Plus";
	public static final String subtract = "Minus";
	public static final String multiply = "Multiply by";
	public static final String divide = "Divide by";
}
