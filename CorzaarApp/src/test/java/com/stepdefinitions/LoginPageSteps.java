package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseClass {

	LoginPage login = new LoginPage(DeviceSessionManager.getDriver());
	HomePage home = new HomePage(DeviceSessionManager.getDriver());

	@When("I select Institute")
	public void selectInstitute() {

		click(DeviceSessionManager.getDriver(), login.institute);

	}

	@And("I enter mobile number {string}")
	public void enterMobileNumber(String number) {

		sendKeys(DeviceSessionManager.getDriver(), login.mobileNumber, number);

	}

	@And("I click on Continue with OTP")
	public void clickContinueWithOtp() {

		click(DeviceSessionManager.getDriver(), login.continueWithOtp);

	}

	@Then("I verify the OTP screen")
	public void verifyOtpScreen() {

		visibilityWait(DeviceSessionManager.getDriver(), login.otpScreen);

	}

	@When("I enter OTP {string}")
	public void enterOtp(String code) {

		sendKeys(DeviceSessionManager.getDriver(), login.otp, code);

	}

	@And("I click on Verify and continue")
	public void clickVerifyAndContinue() {

		//hideKeyboard(DeviceSessionManager.getDriver());
		click(DeviceSessionManager.getDriver(), login.verifyAndContinue);
	}


	@Then("I verify the institute portal is displayed")
	public void verifyInstitutePortal() {

		String a = getText(DeviceSessionManager.getDriver(), login.loginvalidate);
		System.out.println("ValidationText: " + a);
		Assert.assertEquals("Institute portal", a);
	}

	@Then("I verify the OTP screen is not displayed")
	public void verifyOtpScreenNotDisplayed() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), login.otpScreen));
	}

	@Then("I verify the invalid mobile number message is displayed")
	public void verifyInvalidMobileMessage() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), login.mobileError));
	}

	@Then("I verify the institute portal is not displayed")
	public void verifyInstitutePortalNotDisplayed() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), login.loginvalidate));
	}

	@Then("I verify I am still on the OTP screen")
	public void verifyStillOnOtpScreen() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), login.otp));
	}

	
	@Given("I am logged in as an institute")
	public void loggedIn() {

		if (displayed(DeviceSessionManager.getDriver(), login.loginvalidate)) {
			return;
		}
		click(DeviceSessionManager.getDriver(), home.signIn);
		selectInstitute();
		enterMobileNumber("9092023395");
		clickContinueWithOtp();
		verifyOtpScreen();
		enterOtp("123456");
		clickVerifyAndContinue();
		visibilityWait(DeviceSessionManager.getDriver(), login.loginvalidate);
	}
}
