package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CertificatesPage {

	public AndroidDriver driver;

	public CertificatesPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"New template\")")
	public WebElement newTemplate;

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement templateName;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"required (%)\")")
	public WebElement completionRequired;

	@AndroidFindBy(xpath = "//*[contains(@text,'required (%)')]/following::android.widget.EditText[1]")
	public WebElement completionPercent;

	@AndroidFindBy(xpath = "//*[contains(@text,'Accent color')]/following::android.widget.EditText[1]")
	public WebElement accentColor;

	@AndroidFindBy(xpath = "//*[contains(@text,'Signatory name')]/following::android.widget.EditText[1]")
	public WebElement signatoryName;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Manual approval\")")
	public WebElement manualApproval;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create template\")")
	public WebElement createTemplate;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Template created\")")
	public WebElement templateCreatedMessage;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Template name required\")")
	public WebElement templateNameError;

}
