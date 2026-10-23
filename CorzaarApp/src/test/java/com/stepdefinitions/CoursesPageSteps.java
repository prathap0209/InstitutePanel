package com.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CoursesPage;
import com.pages.DashboardPage;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoursesPageSteps extends BaseClass {

	CoursesPage courses = new CoursesPage(DeviceSessionManager.getDriver());
	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());

	String courseName;

	@When("I navigate to the Courses page")
	public void navigateToCoursesPage() {

		clickTab(DeviceSessionManager.getDriver(), courses.coursesTab, dashboard.anyTab);

	}

	@When("I click the Add course button")
	public void clickAddCourse() {

		click(DeviceSessionManager.getDriver(), courses.addCourseButton);

	}

	@When("I enter the course title {string}")
	public void enterCourseTitle(String title) {

		courseName = title + " " + timeStamp();
		sendKeys(DeviceSessionManager.getDriver(), courses.courseTitle, courseName);

	}

	@When("I enter the course description {string}")
	public void enterCourseDescription(String description) {

		sendKeys(DeviceSessionManager.getDriver(), courses.courseDescription, description);
		hideKeyboard(DeviceSessionManager.getDriver());
		scrollToText(DeviceSessionManager.getDriver(), "Duration");
	}

	@When("I select the Technology category")
	public void selectTechnologyCategory() {

		click(DeviceSessionManager.getDriver(), courses.technologyCategory);
		scrollToText(DeviceSessionManager.getDriver(), "Duration");
	}

	@When("I enter the course duration {string}")
	public void enterCourseDuration(String duration) {

		WebElement field = DeviceSessionManager.getDriver()
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"8 weeks\")"));
		field.click();
		field.clear();
		field.sendKeys(duration);

	}

	@When("I enter the course fee {string}")
	public void enterCourseFee(String fee) {

		click(DeviceSessionManager.getDriver(), courses.courseFee);
		sendKeys(DeviceSessionManager.getDriver(), courses.courseFee, fee);
		hideKeyboard(DeviceSessionManager.getDriver());

	}

	@When("I submit the course for admin review")
	public void submitCourseForAdminReview() {

		scrollToText(DeviceSessionManager.getDriver(), "Submit for admin review");
		click(DeviceSessionManager.getDriver(), courses.submitForReview);

	}

	@Then("I verify the course is submitted for admin review")
	public void verifyCourseSubmitted() {

		visibilityWait(DeviceSessionManager.getDriver(), courses.submittedMessage);
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), courses.submittedMessage));
	}

	@Then("I verify the new course is listed on the Courses page")
	public void verifyCourseListed() {

		Assert.assertTrue(textOnScreen(DeviceSessionManager.getDriver(), courseName));
	}

	@Then("I verify the course title validation message is displayed")
	public void verifyTitleValidation() {

		scrollToText(DeviceSessionManager.getDriver(), "Add a course title");
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), courses.titleError));
	}

	@Then("I verify the course is not submitted")
	public void verifyCourseNotSubmitted() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), courses.submittedMessage));
		scrollToText(DeviceSessionManager.getDriver(), "Courses");
	}
}
