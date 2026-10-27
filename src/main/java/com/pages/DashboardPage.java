package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashboardPage {

	public AndroidDriver driver;

	public DashboardPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Institute portal\"]")
	public WebElement portalHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Institute overview\")")
	public WebElement overviewHeading;

	@AndroidFindBy(xpath = "//*[@text=\"Create a course\" or @content-desc=\"Create a course\"]")
	public WebElement createCourseButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Active courses\")")
	public WebElement activeCourses;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Overview\")")
	public WebElement overviewTab;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Batches\"]")
	public WebElement batchesTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coupons\")")
	public WebElement couponsTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Certificates\")")
	public WebElement certificatesTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Insights\")")
	public WebElement insightsTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Payouts\")")
	public WebElement payoutsTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Overview\" or @text=\"Courses\" or @text=\"Batches\" or @text=\"Coupons\" or @text=\"Certificates\" or @text=\"Insights\" or @text=\"Payouts\"]")
	public WebElement anyTab;

}
