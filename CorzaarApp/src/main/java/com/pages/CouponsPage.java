package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CouponsPage {

	public AndroidDriver driver;

	public CouponsPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"New coupon\")")
	public WebElement newCoupon;

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement couponCode;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Discount percent\")")
	public WebElement discountPercent;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit for admin approval\")")
	public WebElement submitCoupon;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add a coupon code\")")
	public WebElement couponCodeError;

}
