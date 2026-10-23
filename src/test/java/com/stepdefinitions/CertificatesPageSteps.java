package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CertificatesPage;
import com.pages.DashboardPage;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CertificatesPageSteps extends BaseClass {

	CertificatesPage certificates = new CertificatesPage(DeviceSessionManager.getDriver());
	DashboardPage dashboard = new DashboardPage(DeviceSessionManager.getDriver());

	String templateNameText;

	@When("I navigate to the Certificates page")
	public void navigateToCertificates() {

		clickTab(DeviceSessionManager.getDriver(), dashboard.certificatesTab, dashboard.anyTab);
	}

	@When("I click the New template button")
	public void clickNewTemplate() {

		click(DeviceSessionManager.getDriver(), certificates.newTemplate);
	}

	@And("I enter the template name {string}")
	public void enterTemplateName(String name) {

		if (name.isEmpty()) {
			templateNameText = "";
			return;
		}
		templateNameText = name + " " + timeStamp();
		sendKeys(DeviceSessionManager.getDriver(), certificates.templateName, templateNameText);
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	@When("I open the {string} tab on the Certificates page")
	public void openCertificatesTab(String tab) {

		click(DeviceSessionManager.getDriver(), DeviceSessionManager.getDriver()
				.findElement(AppiumBy.xpath("//*[@text='" + tab + "' or @content-desc='" + tab + "']")));
	}

	@And("I enter the completion percentage {string}")
	public void enterCompletionPercentage(String percent) {

		if (percent.isEmpty()) {
			return;
		}
		scrollToText(DeviceSessionManager.getDriver(), "required (%)");
		fillField(certificates.completionPercent, percent);
	}

	@And("I select the approval method {string}")
	public void selectApprovalMethod(String method) {

		if (method.isEmpty()) {
			return;
		}
		scrollToText(DeviceSessionManager.getDriver(), method);
		click(DeviceSessionManager.getDriver(), DeviceSessionManager.getDriver()
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + method + "\")")));
	}

	@And("I enter the accent color {string}")
	public void enterAccentColor(String color) {

		if (color.isEmpty()) {
			return;
		}
		scrollToText(DeviceSessionManager.getDriver(), "Accent color");
		fillField(certificates.accentColor, color);
	}

	@And("I enter the signatory name {string}")
	public void enterSignatoryName(String name) {

		if (name.isEmpty()) {
			return;
		}
		scrollToText(DeviceSessionManager.getDriver(), "Signatory name");
		fillField(certificates.signatoryName, name);
	}

	private void fillField(WebElement field, String value) {

		sendKeys(DeviceSessionManager.getDriver(), field, value);
		hideKeyboard(DeviceSessionManager.getDriver());
	}

	@And("I select Manual approval")
	public void selectManualApproval() {

		scrollToText(DeviceSessionManager.getDriver(), "Manual approval");
		click(DeviceSessionManager.getDriver(), certificates.manualApproval);
	}

	@And("I create the template")
	public void createTemplate() {

		scrollToText(DeviceSessionManager.getDriver(), "Create template");
		click(DeviceSessionManager.getDriver(), certificates.createTemplate);
	}

	@Then("I verify the Certificates page is displayed")
	public void verifyCertificatesPage() {

		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), certificates.newTemplate));
	}

	@Then("I verify the template is created")
	public void verifyTemplateCreated() {

		visibilityWait(DeviceSessionManager.getDriver(), certificates.templateCreatedMessage);
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), certificates.templateCreatedMessage));
	}

	@Then("I verify the new template is listed on the Certificates page")
	public void verifyTemplateListed() {

		Assert.assertTrue(textOnScreen(DeviceSessionManager.getDriver(), templateNameText));
	}

	@Then("I verify the template name validation message is displayed")
	public void verifyTemplateNameValidation() {

		scrollToText(DeviceSessionManager.getDriver(), "Template name required");
		Assert.assertTrue(displayed(DeviceSessionManager.getDriver(), certificates.templateNameError));
	}

	@Then("I verify the template is not created")
	public void verifyTemplateNotCreated() {

		Assert.assertFalse(displayed(DeviceSessionManager.getDriver(), certificates.templateCreatedMessage));
	}
}
