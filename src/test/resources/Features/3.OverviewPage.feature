Feature: Institute Overview

@overview
Scenario: Overview is displayed after login
Given I am logged in as an institute
When I navigate to the Overview page
Then I verify the Overview page is displayed
And I verify the Active courses summary is displayed

@overview @positive
Scenario: Create a course button opens the Courses page
Given I am logged in as an institute
When I navigate to the Overview page
And I click the Create a course button
Then I verify the Courses page is displayed

@overview @positive
Scenario: Active courses count matches the published courses
Given I am logged in as an institute
When I navigate to the Overview page
And I note the Active courses count
And I navigate to the Courses page
Then I verify the published courses count matches the Active courses count
