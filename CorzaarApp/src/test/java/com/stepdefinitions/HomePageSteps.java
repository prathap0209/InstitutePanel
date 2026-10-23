package com.stepdefinitions;

import java.util.Map;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseClass {

	HomePage pom = new HomePage(DeviceSessionManager.getDriver());

	
	@Given("I restart the CORZAAR app")
	public void restartApp() {

		String appPackage = DeviceSessionManager.getDriver().getCurrentPackage();
		DeviceSessionManager.getDriver().executeScript("mobile: clearApp", Map.of("appId", appPackage));
		DeviceSessionManager.getDriver().activateApp(appPackage);
		visibilityWait(DeviceSessionManager.getDriver(), pom.signIn);
	}

	@When("I click on Sign in")
	public void clickSignIn() {

		click(DeviceSessionManager.getDriver(), pom.signIn);

	}

	@Then("I verify the login popup")
	public void verifyLoginPopup() {

		visibilityWait(DeviceSessionManager.getDriver(), pom.loginPopup);
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), pom.loginPopup));
	}
}
