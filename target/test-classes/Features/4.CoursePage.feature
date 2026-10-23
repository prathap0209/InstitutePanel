Feature: Institute Courses

@FR-020 @course @positive
Scenario Outline: Add a course
Given I am logged in as an institute
When I navigate to the Courses page
And I click the Add course button
And I enter the course title "<title>"
And I enter the course description "<description>"
And I select the course category "<category>"
And I enter the course duration "<duration>"
And I enter the course fee "<fee>"
And I submit the course for admin review
Then I verify the course is submitted for admin review
And I verify the new course is listed on the Courses page

Examples:
| title                 | description           | category   | duration | fee   |
| Appium mobile testing | android mobile app    | Technology | 10 weeks | 20000 |
| Selenium web testing  | web automation basics | Technology | 6 weeks  | 15000 |

@FR-020 @course @negative
Scenario Outline: Course cannot be submitted with missing details
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Courses page
And I click the Add course button
And I enter the course title "<title>"
And I enter the course description "<description>"
And I select the course category "<category>"
And I enter the course duration "<duration>"
And I enter the course fee "<fee>"
And I submit the course for admin review
Then I verify the text "<message>" is displayed
And I verify the course is not submitted

Examples:
| title               | description        | category   | duration | fee   | message            |
|                     | android mobile app | Technology | 10 weeks | 20000 | Add a course title |
| Negative only title |                    |            |          |       |                    |
| Negative no fee     | android mobile app | Technology | 10 weeks |       |                    |
