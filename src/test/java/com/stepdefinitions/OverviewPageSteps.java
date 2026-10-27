package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CoursesPage;
import com.pages.DashboardPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OverviewPageSteps extends BaseClass {

	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());
	CoursesPage courses = new CoursesPage(DeviceSessionManager.getDriver());

	int activeCoursesCount;

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

	@When("I click the Create a course button")
	public void clickCreateCourse() {

		click(DeviceSessionManager.getDriver(), dashboard.createCourseButton);
	}

	@When("I note the Active courses count")
	public void noteActiveCoursesCount() {

		scrollToText(DeviceSessionManager.getDriver(), "Active courses");
		activeCoursesCount = getCountByLabel(DeviceSessionManager.getDriver(), "Active courses");
	}

	@Then("I verify the published courses count matches the Active courses count")
	public void verifyPublishedCoursesCount() {

		Assert.assertEquals(activeCoursesCount, getSize(DeviceSessionManager.getDriver(), courses.publishedCourses));
	}
}
