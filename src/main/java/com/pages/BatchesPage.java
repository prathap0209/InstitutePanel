package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BatchesPage {

	public AndroidDriver driver;

	public BatchesPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"New batch\"]")
	public WebElement createBatchButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create batch\"]")
	public WebElement submitBatch;

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement batchName;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Mon Wed 7-9pm\"]")
	public WebElement schedule;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"2026-04-01\"]")
	public WebElement startDate;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"2026-06-01\"]")
	public WebElement endDate;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Batch created\")")
	public WebElement batchCreatedMessage;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Choose a session above\")")
	public WebElement chooseSessionMessage;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Attendance appears once\")")
	public WebElement noStudentsMessage;

	@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\".*(\\\\d{4}-\\\\d{2}-\\\\d{2}|Session).*\").instance(0)")
	public WebElement firstSession;

	@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)present\").instance(0)")
	public WebElement firstStudentPresent;

	@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)absent\").instance(0)")
	public WebElement firstStudentAbsent;

	@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)absent\").instance(1)")
	public WebElement secondStudentAbsent;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Could not update attendance\")")
	public WebElement attendanceError;

}
