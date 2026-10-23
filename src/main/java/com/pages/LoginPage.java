package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);

    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Institute\")")
    public WebElement institute;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mobile number\")")
    public WebElement mobileNumberLabel;

    @AndroidFindBy(xpath= "//android.widget.EditText[@resource-id=\"auth-phone\"]")
    public WebElement mobileNumber;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue with OTP\")")
    public WebElement continueWithOtp;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Enter the 6-digit code\")")
    public WebElement otpScreen;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"auth-otp\"]")
    public WebElement otp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Verify and continue\"]")
    public WebElement verifyAndContinue;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Institute portal\"]")
    public WebElement loginvalidate;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"valid mobile\")")
    public WebElement mobileError;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Resend\")")
    public WebElement resendCode;
}
