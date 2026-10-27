Feature: Institute Certificates

@FR-024 @certificate @positive
Scenario: Certificates page is displayed
Given I am logged in as an institute
When I navigate to the Certificates page
Then I verify the Certificates page is displayed

@FR-024 @certificate @positive
Scenario Outline: Issued, Revoked and Templates tabs are displayed
Given I am logged in as an institute
When I navigate to the Certificates page
And I open the "<tab>" tab on the Certificates page
Then I verify the text "<text>" is displayed

Examples:
| tab       | text                 |
| Issued    | Issued certificates  |
| Revoked   | Revoked certificates |
| Templates | New template         |

@FR-024 @certificate @positive
Scenario Outline: Create a certificate template
Given I am logged in as an institute
When I navigate to the Certificates page
And I open the "Templates" tab on the Certificates page
And I click the New template button
And I enter the template name "<name>"
And I enter the completion percentage "<completion>"
And I select the approval method "<approval>"
And I enter the accent color "<accent>"
And I enter the signatory name "<signatory>"
And I create the template
Then I verify the template is created
And I verify the new template is listed on the Certificates page

Examples:
| name            | completion | approval        | accent  | signatory |
| Appium Template |            | Manual approval |         |           |
| Full Template   | 80         | Manual approval | #1E3A5F | Priya     |

@FR-024 @certificate @negative
Scenario Outline: Certificate template cannot be created with missing or wrong details
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Certificates page
And I open the "Templates" tab on the Certificates page
And I click the New template button
And I enter the template name "<name>"
And I enter the completion percentage "<completion>"
And I create the template
Then I verify the text "<message>" is displayed
And I verify the template is not created

Examples:
| name        | completion | message                |
|             |            | Template name required |
| Bad percent | 150        |                        |

@FR-024 @certificate @positive
Scenario Outline: Certificate tile count matches the listed certificates
Given I am logged in as an institute
When I navigate to the Certificates page
And I open the "<tile>" tab on the Certificates page
Then I verify the "<tile>" tile count matches the listed certificates

Examples:
| tile    |
| Pending |
| Issued  |
| Revoked |

@FR-024 @certificate @positive
Scenario Outline: Preview a certificate template
Given I am logged in as an institute
When I navigate to the Certificates page
And I open the "Templates" tab on the Certificates page
And I click Preview for the template "<template>"
Then I verify the template preview is displayed

Examples:
| template        |
| Appium Template |

@FR-024 @certificate @positive
Scenario Outline: Delete a certificate template
Given I am logged in as an institute
When I navigate to the Certificates page
And I open the "Templates" tab on the Certificates page
And I click Delete for the template "<template>"
Then I verify the template is deleted

Examples:
| template        |
| Appium Template |
