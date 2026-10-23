Feature: Institute Insights

@insights @positive
Scenario: Insights page shows the rating details
Given I am logged in as an institute
When I navigate to the Insights page
Then I verify the text "<text>" is displayed

