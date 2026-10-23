Feature: CORZAAR Login Page

@FR-001 @login @negative
Scenario Outline: Institute cannot request OTP with an invalid or empty mobile number
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "<mobile>"
And I click on Continue with OTP
Then I verify the OTP screen is not displayed
And I verify the text "<message>" is displayed

Examples:
| mobile  | message      |
| 123     | valid mobile |
| 1234567 | valid mobile |
|         |              |

@FR-002 @login @negative
Scenario Outline: Institute cannot login with a wrong or empty OTP
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "<mobile>"
And I click on Continue with OTP
Then I verify the OTP screen
When I enter OTP "<otp>"
And I click on Verify and continue
Then I verify the institute portal is not displayed
And I verify I am still on the OTP screen

Examples:
| mobile     | otp    |
| 9092023395 | 000000 |
| 9092023395 | 111111 |
| 9092023395 |        |

@login @negative
Scenario Outline: Institute cannot login with a wrong OTP after using Resend code
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "<mobile>"
And I click on Continue with OTP
Then I verify the OTP screen
When I click on Resend code
And I enter OTP "<otp>"
And I click on Verify and continue
Then I verify the institute portal is not displayed
And I verify I am still on the OTP screen

Examples:
| mobile     | otp    |
| 9092023395 | 000000 |

@FR-001 @FR-002 @login @positive
Scenario Outline: Login as Institute
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "<mobile>"
And I click on Continue with OTP
Then I verify the OTP screen
When I enter OTP "<otp>"
And I click on Verify and continue
Then I verify the institute portal is displayed

Examples:
| mobile     | otp    |
| 9092023395 | 123456 |

@login @positive
Scenario Outline: Login as Institute after using Resend code
Given I restart the CORZAAR app
When I click on Sign in
And I select Institute
And I enter mobile number "<mobile>"
And I click on Continue with OTP
Then I verify the OTP screen
When I click on Resend code
Then I verify the text "Code sent" is displayed
When I enter OTP "<otp>"
And I click on Verify and continue
Then I verify the institute portal is displayed

Examples:
| mobile     | otp    |
| 9092023395 | 123456 |
