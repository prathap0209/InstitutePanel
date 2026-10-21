Feature: Institute Batches and Attendance

@FR-021 @batch @positive
Scenario: Create a batch for the course
Given I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I select the course "Appium mobile testing" for the batch
#And I enter the batch name "Appium Batch"
And I enter the batch schedule "Mon Wed 7-9pm"
And I enter the batch start date 1 days from today
And I enter the batch end date 30 days from today
And I submit the batch
Then I verify the batch is created
And I verify the new batch is listed on the Batches page

@FR-021 @batch @negative
Scenario: Batch cannot be created with an empty form
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I submit the batch
Then I verify the batch is not created

@FR-021 @batch @negative
Scenario: Batch cannot be created without a schedule
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I select the course "Appium mobile testing" for the batch
And I enter the batch name "Negative no schedule"
And I enter the batch start date 1 days from today
And I enter the batch end date 30 days from today
And I submit the batch
Then I verify the batch is not created

@FR-021 @batch @negative
Scenario: Batch cannot be created without selecting a course
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I enter the batch name "Negative no course"
And I enter the batch schedule "Mon Wed 7-9pm"
And I enter the batch start date 1 days from today
And I enter the batch end date 30 days from today
And I submit the batch
Then I verify the batch is not created

@FR-021 @batch @negative
Scenario: Batch cannot be created when the end date is before the start date
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I select the course "Appium mobile testing" for the batch
And I enter the batch name "Negative dates"
And I enter the batch schedule "Mon Wed 7-9pm"
And I enter the batch start date 30 days from today
And I enter the batch end date 1 days from today
And I submit the batch
Then I verify the batch is not created

@FR-021 @batch @negative
Scenario: Batch cannot be created with a wrong date format
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I select the course "Appium mobile testing" for the batch
And I enter the batch name "Negative format"
And I enter the batch schedule "Mon Wed 7-9pm"
And I enter the batch start date "31-12-2026"
And I enter the batch end date 30 days from today
And I submit the batch
Then I verify the batch is not created


@FR-022 @attendance @positive
Scenario: Mark attendance as present and absent
Given I am logged in as an institute
When I navigate to the Batches page
And I open attendance for the course "Course With Students"
And I select the first session
Then I verify the attendance roster is displayed
When I mark the first student as Present
And I mark the second student as Absent
Then I verify the attendance is saved without errors

@FR-022 @attendance @negative
Scenario: Attendance roster is not shown until a session is chosen
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I open attendance for the course "Course With Students"
Then I verify the choose a session message is displayed
And I verify the attendance roster is not displayed

@FR-022 @attendance @negative
Scenario: No attendance roster for a course without enrolled students
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I open attendance for the course "Course Without Students"
Then I verify the no students message is displayed
And I verify the attendance roster is not displayed
