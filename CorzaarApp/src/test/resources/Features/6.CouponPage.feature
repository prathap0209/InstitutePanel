Feature: Institute Coupons

@FR-023 @coupon @positive
Scenario: Create a new coupon
Given I am logged in as an institute
When I navigate to the Coupons page
And I click the New coupon button
And I enter the coupon code "AUTO"
And I enter the discount percent "10"
And I submit the coupon for admin approval
Then I verify the new coupon is listed on the Coupons page

@FR-023 @coupon @negative
Scenario: Coupon cannot be created without a code
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Coupons page
And I click the New coupon button
And I enter the discount percent "10"
And I submit the coupon for admin approval
Then I verify the coupon code validation message is displayed

@FR-023 @coupon @negative
Scenario: Coupon cannot be created without a discount percent
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Coupons page
And I click the New coupon button
And I enter the coupon code "NOPCT"
And I submit the coupon for admin approval
Then I verify the coupon is not listed on the Coupons page

@FR-023 @coupon @negative
Scenario Outline: Coupon cannot be created with a discount that is not a whole number from 1 to 100
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Coupons page
And I click the New coupon button
And I enter the coupon code "BAD"
And I enter the discount percent "<percent>"
And I submit the coupon for admin approval
Then I verify the coupon is not listed on the Coupons page

Examples:
| percent |
| 0       |
| 101     |
| 10.5    |
