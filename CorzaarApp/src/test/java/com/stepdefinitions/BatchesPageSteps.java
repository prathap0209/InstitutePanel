package com.stepdefinitions;

import java.time.LocalDate;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.BatchesPage;
import com.pages.DashboardPage;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchesPageSteps extends BaseClass {

	BatchesPage batches = new BatchesPage(DeviceSessionManager.getDriver());
	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());

	String batchNameText;

	@When("I navigate to the Batches page")
	public void navigateToBatches() {
      //scrollToText(DeviceSessionManager.getDriver(), "Batches");
		
		//clickTab(DeviceSessionManager.getDriver(), dashboard.batchesTab, dashboard.anyTab);
		click(DeviceSessionManager.getDriver(), dashboard.batchesTab);
	}


	@When("I click the Create batch button")
	public void clickCreateBatch() {

		click(DeviceSessionManager.getDriver(), batches.createBatchButton);
	}

	@And("I select the course {string} for the batch")
	public void selectCourse(String course) {

		click(DeviceSessionManager.getDriver(), scrollToText(DeviceSessionManager.getDriver(), course));
	}

//	@And("I enter the batch name {string}")
//	public void enterBatchName(String name) {
//
//		batchNameText = name + " " + timeStamp();
//		sendKeys(DeviceSessionManager.getDriver(), batches.batchName, batchNameText);
//		hideKeyboard(DeviceSessionManager.getDriver());
//	}

	@And("I enter the batch schedule {string}")
	public void enterSchedule(String schedule) {

		scrollToText(DeviceSessionManager.getDriver(), "Schedule (include days");
		sendKeys(DeviceSessionManager.getDriver(), batches.schedule, schedule);
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	// the batch form expects YYYY-MM-DD
	@And("I enter the batch start date {int} days from today")
	public void enterStartDate(int days) {

		enterStartDateText(LocalDate.now().plusDays(days).toString());
	}

	@And("I enter the batch start date {string}")
	public void enterStartDateText(String date) {

		scrollToText(DeviceSessionManager.getDriver(), "Start (YYYY");
		sendKeys(DeviceSessionManager.getDriver(), batches.startDate, date);
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	@And("I enter the batch end date {int} days from today")
	public void enterEndDate(int days) {

		scrollToText(DeviceSessionManager.getDriver(), "End (YYYY");
		sendKeys(DeviceSessionManager.getDriver(), batches.endDate, LocalDate.now().plusDays(days).toString());
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	@And("I submit the batch")
	public void submitBatch() {

		scrollToText(DeviceSessionManager.getDriver(), "Create batch");
		click(DeviceSessionManager.getDriver(), batches.submitBatch);
	}


	@Then("I verify the batch is created")
	public void verifyBatchCreated() {

		visibilityWait(DeviceSessionManager.getDriver(), batches.batchCreatedMessage);
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), batches.batchCreatedMessage));
	}

	@Then("I verify the new batch is listed on the Batches page")
	public void verifyBatchListed() {

		Assert.assertTrue(textOnScreen(DeviceSessionManager.getDriver(), batchNameText));
	}

	@Then("I verify the batch is not created")
	public void verifyBatchNotCreated() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), batches.batchCreatedMessage));
	}


	@When("I open attendance for the course {string}")
	public void openAttendance(String course) {

		scrollToText(DeviceSessionManager.getDriver(), "Choose a course");
		click(DeviceSessionManager.getDriver(), DeviceSessionManager.getDriver().findElement(AppiumBy.xpath(
				"(//*[contains(@text,'Choose a course')])[last()]/following::*[contains(@text,'" + course + "')][1]")));
	}

	@And("I select the first session")
	public void selectFirstSession() {

		click(DeviceSessionManager.getDriver(), batches.firstSession);
	}

	@When("I mark the first student as Present")
	public void markFirstPresent() {

		scrollToText(DeviceSessionManager.getDriver(), "Present");
		click(DeviceSessionManager.getDriver(), batches.firstStudentPresent);
	}

	@When("I mark the first student as Absent")
	public void markFirstAbsent() {

		click(DeviceSessionManager.getDriver(), batches.firstStudentAbsent);
	}

	@When("I mark the second student as Absent")
	public void markSecondAbsent() {

		click(DeviceSessionManager.getDriver(), batches.secondStudentAbsent);
	}


	@Then("I verify the attendance roster is displayed")
	public void verifyRoster() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), batches.firstStudentPresent));
	}

	@Then("I verify the attendance roster is not displayed")
	public void verifyRosterNotDisplayed() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), batches.firstStudentPresent));
	}

	@Then("I verify the choose a session message is displayed")
	public void verifyChooseSession() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), batches.chooseSessionMessage));
	}

	@Then("I verify the no students message is displayed")
	public void verifyNoStudents() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), batches.noStudentsMessage));
	}

	@Then("I verify the attendance is saved without errors")
	public void verifyAttendanceSaved() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), batches.attendanceError));
	}
}
