Feature: Institute Courses

@FR-020 @course @positive
Scenario: Add Appium mobile testing course
Given I am logged in as an institute
When I navigate to the Courses page
And I click the Add course button
And I enter the course title "Appium mobile testing"
And I enter the course description "android mobile app"
And I select the Technology category
And I enter the course duration "10 weeks"
And I enter the course fee "20000"
And I submit the course for admin review
Then I verify the course is submitted for admin review
And I verify the new course is listed on the Courses page

@FR-020 @course @negative
Scenario: Course cannot be submitted without a title
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Courses page
And I click the Add course button
And I submit the course for admin review
Then I verify the course title validation message is displayed
And I verify the course is not submitted

@FR-020 @course @negative
Scenario: Course cannot be submitted with only a title
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Courses page
And I click the Add course button
And I enter the course title "Negative only title"
And I submit the course for admin review
Then I verify the course is not submitted


@FR-020 @course @negative
Scenario: Course cannot be submitted without a fee
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Courses page
And I click the Add course button
And I enter the course title "Negative no fee"
And I enter the course description "android mobile app"
And I select the Technology category
And I enter the course duration "10 weeks"
And I submit the course for admin review
Then I verify the course is not submitted
