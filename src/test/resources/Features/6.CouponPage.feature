Feature: Institute Coupons

@FR-023 @coupon @positive
Scenario Outline: Create a new coupon
Given I am logged in as an institute
When I navigate to the Coupons page
And I click the New coupon button
And I enter the coupon code "<code>"
And I enter the discount percent "<percent>"
And I submit the coupon for admin approval
Then I verify the new coupon is listed on the Coupons page

Examples:
| code | percent |
| AUTO | 10      |
| FULL | 100     |

@FR-023 @coupon @negative
Scenario Outline: Coupon cannot be created with a missing code or a wrong discount
Given I restart the CORZAAR app
And I am logged in as an institute
When I navigate to the Coupons page
And I click the New coupon button
And I enter the coupon code "<code>"
And I enter the discount percent "<percent>"
And I submit the coupon for admin approval
Then I verify the text "<message>" is displayed
And I verify the coupon is not listed on the Coupons page

Examples:
| code  | percent | message           |
|       | 10      | Add a coupon code |
| NOPCT |         |                   |
| BAD   | 0       |                   |
| BAD   | 101     |                   |
| BAD   | 10.5    |                   |
