Feature: Institute Batches and Attendance

@FR-021 @batch @positive
Scenario Outline: Create a batch for the course
Given I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I select the course "<course>" for the batch
And I enter the batch schedule "<schedule>"
And I enter the batch start date "<start>"
And I enter the batch end date "<end>"
And I submit the batch
Then I verify the batch is created
And I verify the new batch is listed on the Batches page

Examples:
| course                | schedule      | start | end |
| Appium mobile testing | Mon Wed 7-9pm | +1    | +30 |

@FR-021 @batch @negative
Scenario Outline: Batch cannot be created with missing or wrong details
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I click the Create batch button
And I select the course "<course>" for the batch
And I enter the batch schedule "<schedule>"
And I enter the batch start date "<start>"
And I enter the batch end date "<end>"
And I submit the batch
Then I verify the batch is not created

Examples:
| course                | schedule      | start      | end |
|                       |               |            |     |
| Appium mobile testing |               | +1         | +30 |
|                       | Mon Wed 7-9pm | +1         | +30 |
| Appium mobile testing | Mon Wed 7-9pm | +30        | +1  |
| Appium mobile testing | Mon Wed 7-9pm | 31-12-2026 | +30 |

@FR-022 @attendance @positive
Scenario Outline: Mark attendance as present and absent
Given I am logged in as an institute
When I navigate to the Batches page
And I open attendance for the course "<course>"
And I select the first session
Then I verify the attendance roster is displayed
When I mark the first student as Present
And I mark the second student as Absent
Then I verify the attendance is saved without errors

Examples:
| course               |
| Course With Students |

@FR-022 @attendance @negative
Scenario Outline: Attendance roster is not shown without a session or without students
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Batches page
And I open attendance for the course "<course>"
Then I verify the text "<message>" is displayed
And I verify the attendance roster is not displayed

Examples:
| course                  | message                 |
| Course With Students    | Choose a session above  |
| Course Without Students | Attendance appears once |
