package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	       @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in\")")
		    public WebElement signIn;
	       
		    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Welcome back\")")
		    public WebElement loginPopup;

		
	

}
