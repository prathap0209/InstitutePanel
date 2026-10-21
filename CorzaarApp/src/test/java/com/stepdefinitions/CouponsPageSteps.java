package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CouponsPage;
import com.pages.DashboardPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CouponsPageSteps extends BaseClass {

	CouponsPage coupons = new CouponsPage(DeviceSessionManager.getDriver());
	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());

	String couponName;

	@When("I navigate to the Coupons page")
	public void navigateToCoupons() {

		clickTab(DeviceSessionManager.getDriver(), dashboard.couponsTab, dashboard.anyTab);
	}

	@When("I click the New coupon button")
	public void clickNewCoupon() {

		click(DeviceSessionManager.getDriver(), coupons.newCoupon);
	}

	@And("I enter the coupon code {string}")
	public void enterCouponCode(String code) {

		couponName = code + timeStamp();
		sendKeys(DeviceSessionManager.getDriver(), coupons.couponCode, couponName);
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	@And("I enter the discount percent {string}")
	public void enterDiscountPercent(String percent) {

		sendKeys(DeviceSessionManager.getDriver(), coupons.discountPercent, percent);
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	@And("I submit the coupon for admin approval")
	public void submitCoupon() {

		scrollToText(DeviceSessionManager.getDriver(), "Submit for admin approval");
		click(DeviceSessionManager.getDriver(), coupons.submitCoupon);
	}


	@Then("I verify the new coupon is listed on the Coupons page")
	public void verifyCouponListed() {

		Assert.assertTrue(textOnScreen(DeviceSessionManager.getDriver(), couponName));
	}

	@Then("I verify the coupon is not listed on the Coupons page")
	public void verifyCouponNotListed() {

		Assert.assertFalse(textOnScreen(DeviceSessionManager.getDriver(), couponName));
	}

	@Then("I verify the coupon code validation message is displayed")
	public void verifyCodeValidation() {

		scrollToText(DeviceSessionManager.getDriver(), "Add a coupon code");
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), coupons.couponCodeError));
	}
}
