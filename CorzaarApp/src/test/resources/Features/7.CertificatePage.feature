Feature: Institute Certificates

@FR-024 @certificate @positive
Scenario: Certificates page is displayed
Given I am logged in as an institute
When I navigate to the Certificates page
Then I verify the Certificates page is displayed

@FR-024 @certificate @positive
Scenario: Create a certificate template
Given I am logged in as an institute
When I navigate to the Certificates page
And I click the New template button
And I enter the template name "Appium Template"
And I select Manual approval
And I create the template
Then I verify the template is created
And I verify the new template is listed on the Certificates page

@FR-024 @certificate @negative
Scenario: Certificate template cannot be created without a name
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Certificates page
And I click the New template button
And I create the template
Then I verify the template name validation message is displayed
And I verify the template is not created
