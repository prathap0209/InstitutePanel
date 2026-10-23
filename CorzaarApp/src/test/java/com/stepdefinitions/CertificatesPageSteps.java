package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CertificatesPage;
import com.pages.DashboardPage;

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

		templateNameText = name + " " + timeStamp();
		sendKeys(DeviceSessionManager.getDriver(), certificates.templateName, templateNameText);
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

	// ---------- validations ----------

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
