Feature: Institute Overview

@overview
Scenario: Overview is displayed after login
Given I am logged in as an institute
When I navigate to the Overview page
Then I verify the Overview page is displayed
And I verify the Active courses summary is displayed
