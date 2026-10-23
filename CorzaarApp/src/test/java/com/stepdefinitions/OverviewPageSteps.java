package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.DashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OverviewPageSteps extends BaseClass {

	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());

	@When("I navigate to the Overview page")
	public void navigateToOverview() {

		clickTab(DeviceSessionManager.getDriver(), dashboard.overviewTab, dashboard.anyTab);
	}

	@Then("I verify the Overview page is displayed")
	public void verifyOverview() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), dashboard.portalHeader));
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), dashboard.overviewHeading));
	}

	@Then("I verify the Active courses summary is displayed")
	public void verifyActiveCourses() {

		scrollToText(DeviceSessionManager.getDriver(), "Active courses");
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), dashboard.activeCourses));
	}
}
