package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;

import io.cucumber.java.en.Then;

public class CommonSteps extends BaseClass {

	@Then("I verify the text {string} is displayed")
	public void verifyTextDisplayed(String text) throws InterruptedException {

		if (text.isEmpty()) {
			return;
		}
		Assert.assertTrue("Not found on the screen: " + text, waitForText(DeviceSessionManager.getDriver(), text));
	}

	@Then("I verify the text {string} is not displayed")
	public void verifyTextNotDisplayed(String text) {

		if (text.isEmpty()) {
			return;
		}
		Assert.assertFalse("Should not be on the screen: " + text, textOnScreen(DeviceSessionManager.getDriver(), text));
	}
}
