package com.stepdefinitions;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.DashboardPage;

import io.cucumber.java.en.When;

public class InsightsPayoutsPageSteps extends BaseClass {

	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());

	@When("I navigate to the Insights page")
	public void navigateToInsights() {

		clickTab(DeviceSessionManager.getDriver(), dashboard.insightsTab, dashboard.anyTab);
	}

	@When("I navigate to the Payouts page")
	public void navigateToPayouts() {

		clickTab(DeviceSessionManager.getDriver(), dashboard.payoutsTab, dashboard.anyTab);
	}
}
