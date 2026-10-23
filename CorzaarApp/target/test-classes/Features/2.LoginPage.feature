Feature: CORZAAR Login Page

@FR-001 @login @negative
Scenario Outline: Institute cannot request OTP with an invalid mobile number
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "<mobile>"
And I click on Continue with OTP
Then I verify the OTP screen is not displayed
And I verify the invalid mobile number message is displayed

Examples:
| mobile  |
| 123     |
| 1234567 |

@FR-001 @login @negative
Scenario: Institute cannot request OTP with an empty mobile number
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I click on Continue with OTP
Then I verify the OTP screen is not displayed

@FR-002 @login @negative
Scenario Outline: Institute cannot login with a wrong OTP
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "9092023395"
And I click on Continue with OTP
Then I verify the OTP screen
When I enter OTP "<otp>"
And I click on Verify and continue
Then I verify the institute portal is not displayed
And I verify I am still on the OTP screen

Examples:
| otp    |
| 000000 |
| 111111 |

@FR-002 @login @negative
Scenario: Institute cannot login with an empty OTP
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "9092023395"
And I click on Continue with OTP
Then I verify the OTP screen
When I click on Verify and continue
Then I verify the institute portal is not displayed

@FR-001 @FR-002 @login @positive
Scenario: Login as Institute
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "9092023395"
And I click on Continue with OTP
Then I verify the OTP screen
When I enter OTP "123456"
And I click on Verify and continue
Then I verify the institute portal is displayed
